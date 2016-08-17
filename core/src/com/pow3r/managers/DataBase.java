package com.pow3r.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.pow3r.objects.Unit;

import sun.rmi.runtime.Log;

/**
 * Created by anton on 07.07.2016.
 */
public abstract class DataBase {

    protected static String database_name = "power.db";
    protected static DataBase instance = null;
    protected static int version = 1;

    public abstract void insertInitialData();

    public abstract void execute(String sql);

    public abstract Unit getUnitById(Integer id);

    public abstract Array<Unit> getUnits();

    public abstract Integer getCountUnits();

    public abstract void closeDB();

}

