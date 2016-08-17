package com.pow3r.objects;

import com.pow3r.managers.DatabaseManager;

/**
 * Created by anton on 16.05.2016.
 */
public class Player {

    Integer id;
    String name;
    Unit unit1;
    Unit unit2;
    Unit unit3;

    Unit selectedUnit;

    public Player(Integer id) {
        this.id = id;
        if(id==1) {
            this.unit1 = DatabaseManager.getDataBase().getUnitById(1);
            this.unit2 = DatabaseManager.getDataBase().getUnitById(2);
            this.unit3 = DatabaseManager.getDataBase().getUnitById(3);
        }
        else {
            this.unit1 = DatabaseManager.getDataBase().getUnitById(4);
            this.unit2 = DatabaseManager.getDataBase().getUnitById(5);
            this.unit3 = DatabaseManager.getDataBase().getUnitById(6);
        }

    }
}
