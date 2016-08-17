package com.pow3r.game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.badlogic.gdx.utils.Array;
import com.pow3r.managers.DataBase;
import com.pow3r.objects.Unit;

/**
 * Created by anton on 07.07.2016.
 */
public class DatabaseAndroid extends DataBase {

    protected SQLiteOpenHelper db_connection;
    protected SQLiteDatabase stmt;
    public Context context;

    public DatabaseAndroid(Context context) {
        this.context = context;
        db_connection = new AndroidDB(context, database_name, null, version);
        if(checkDataBase()) {
            stmt = db_connection.getWritableDatabase();
        }
        else{
            stmt = db_connection.getWritableDatabase();
            this.insertInitialData();
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = "/data/data/com.pow3r.game/databases/" + DatabaseAndroid.database_name;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }


    public void insertInitialData(){
        insertUnit("unit1", 10, 10, 10, "description unit1");
        insertUnit("unit2", 12, 7, 10, "description unit2");
        insertUnit("unit3", 6, 15, 11, "description unit3");
        insertUnit("unit4", 6, 5, 5, "description unit4");
        insertUnit("unit5", 15, 17, 14, "description unit5");
        insertUnit("unit6", 11, 9, 9, "description unit6");
        insertAbility("dmg", "Damage enemy", "3", "pow1", 1l, "ability1");
        insertAbility("self", "Heal self", "4", "pow1", 1l, "ability2");
        insertAbility("dmg", "Damage enemy", "3", "pow2", 1l, "ability3");
        insertAbility("dmg,self", "Damage enemy and damage self", "6,3", "pow2", 1l, "ability4");
        insertAbility("dmg", "Damage enemy", "3", "pow3", 1l, "ability5");
        insertAbility("self", "Heal self", "5", "pow3", 1l, "ability6");

        insertAbility("dmg%", "Damage enemy %", "0.5", "pow1", 2l, "ability1");
        insertAbility("self%", "Heal self", "0.25", "pow1", 2l, "ability2");
        insertAbility("dmg", "Damage enemy", "4", "pow2", 2l, "ability3");
        insertAbility("dmg,self", "Damage enemy and damage self", "7,3", "pow2", 2l, "ability4");
        insertAbility("dmg", "Damage enemy", "3", "pow3", 2l, "ability5");
        insertAbility("self", "Heal self", "5", "pow3", 2l, "ability6");
    }

    public void execute(String sql) {
        stmt.execSQL(sql);
    }

    public Unit getUnitById(Integer id) {
        Cursor cursor = stmt.rawQuery("select * from unit where _id= " + id, null);
        Unit unit = new Unit();
        if (cursor.moveToFirst()) {
            unit.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            unit.setName(cursor.getString(cursor.getColumnIndex("name")));
            unit.setPow1(cursor.getInt(cursor.getColumnIndex("pow1")));
            unit.setPow2(cursor.getInt(cursor.getColumnIndex("pow2")));
            unit.setPow3(cursor.getInt(cursor.getColumnIndex("pow3")));
            unit.setDescription(cursor.getString(cursor.getColumnIndex("descr")));
        }
        cursor.close();
        return unit;
    }

    public Array<Unit> getUnits() {
        Cursor cursor = stmt.rawQuery("select * from unit", null);
        Array<Unit> listUnits = new Array<>();
        if (cursor.moveToFirst()) {
            do{
                Unit unit = new Unit();
                unit.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                unit.setName(cursor.getString(cursor.getColumnIndex("name")));
                unit.setPow1(cursor.getInt(cursor.getColumnIndex("pow1")));
                unit.setPow2(cursor.getInt(cursor.getColumnIndex("pow2")));
                unit.setPow3(cursor.getInt(cursor.getColumnIndex("pow3")));
                unit.setDescription(cursor.getString(cursor.getColumnIndex("descr")));
                listUnits.add(unit);
            } while(cursor.moveToNext());
        }
        cursor.close();
        return listUnits;
    }

    public Integer getCountUnits(){
        Cursor cursor = stmt.rawQuery("select * from unit", null);
        return cursor.getCount();
    }

    public void closeDB() {
        db_connection.close();
        stmt.close();
    }

    public long insertUnit(String name, Integer pow1, Integer pow2, Integer pow3, String descr) {
        SQLiteStatement insertStmt = this.stmt.compileStatement("INSERT INTO unit (name, pow1, pow2, pow3, descr) VALUES (?,?,?,?,?)");
        insertStmt.bindString(1, name);
        insertStmt.bindLong(2, pow1);
        insertStmt.bindLong(3, pow2);
        insertStmt.bindLong(4, pow3);
        insertStmt.bindString(5, descr);
        return insertStmt.executeInsert();
    }

    public long insertAbility(String type, String name, String work, String pow, Long unitId, String descr) {
        SQLiteStatement insertStmt = this.stmt.compileStatement("INSERT INTO ability (type, name, work, pow, unit_id, descr) VALUES (?,?,?,?,?,?)");
        insertStmt.bindString(1, type);
        insertStmt.bindString(2, name);
        insertStmt.bindString(3, work);
        insertStmt.bindString(4, pow);
        insertStmt.bindLong(5, unitId);
        insertStmt.bindString(6, descr);
        return insertStmt.executeInsert();
    }

    class AndroidDB extends SQLiteOpenHelper {

        public AndroidDB(Context context, String name, SQLiteDatabase.CursorFactory factory,
                         int version) {
            super(context, name, factory, version);
        }

        public AndroidDB(Context context) {
            super(context, database_name, null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE unit (_id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    "name VARCHAR NOT NULL , " +    // имя персонажа
                    "pow1 INTEGER NOT NULL , " +    // здоровье силы 1
                    "pow2 INTEGER NOT NULL , " +    // здоровье силы 2
                    "pow3 INTEGER NOT NULL , " +    // здоровье силы 3
                    "descr VARCHAR NOT NULL " +     // описание персонажа
                    "); ");

            db.execSQL("CREATE TABLE ability (_id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    "type VARCHAR NOT NULL , " +    // тип способности
                    "name VARCHAR NOT NULL , " +    // название способности
                    "work VARCHAR NOT NULL , " +    // принцип работы, параметры
                    "pow VARCHAR NOT NULL , " +    // номер силы
                    "unit_id INTEGER NOT NULL , " +     // способность какого персонажа
                    "descr VARCHAR NOT NULL , " +     // описание способности
                    "FOREIGN KEY(unit_id) REFERENCES unit(id) " +
                    "); ");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            stmt = db;
            execute("DROP TABLE IF EXISTS 'unit';");
            execute("DROP TABLE IF EXISTS 'ability';");
            onCreate(db);
        }
    }
}
