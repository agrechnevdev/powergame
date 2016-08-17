package com.pow3r.managers;

import com.badlogic.gdx.Game;

/**
 * Created by anton on 19.07.2016.
 */
public class DatabaseManager {

    private static DatabaseManager instance;
    private static DataBase dataBase;

    public static DatabaseManager getInstance() {
        if (null == instance) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void init(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public static DataBase getDataBase() {
        return dataBase;
    }
}
