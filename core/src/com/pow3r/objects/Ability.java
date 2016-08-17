package com.pow3r.objects;

/**
 * Created by anton on 17.04.2016.
 */
public class Ability {

    public Integer id;
    public String type;
    public String name;
    public String work;
    public String description;
    public Unit unitId;
    public String pow;

    public Ability() {
    }

    public void use(Unit selectUnit1, Unit selectUnit2, Ability selectAbil1, Ability selectAbil2){
        if(type.equals("dmg")){
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
