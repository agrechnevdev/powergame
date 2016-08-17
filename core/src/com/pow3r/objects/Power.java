package com.pow3r.objects;

/**
 * Created by anton on 17.04.2016.
 */
public class Power {

    public Integer id;
    public String name;
    public Integer hp;
    private Ability abilA;
    private Ability abilB;
    private Ability abilC;

    public Power(){

    }

    public Power(Integer id, String name, Integer hp, Ability abilA, Ability abilB, Ability abilC) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.abilA = abilA;
        this.abilB = abilB;
        this.abilC = abilC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Ability getAbilA() {
        return abilA;
    }

    public void setAbilA(Ability abilA) {
        this.abilA = abilA;
    }

    public Ability getAbilB() {
        return abilB;
    }

    public void setAbilB(Ability abilB) {
        this.abilB = abilB;
    }

    public Ability getAbilC() {
        return abilC;
    }

    public void setAbilC(Ability abilC) {
        this.abilC = abilC;
    }
}
