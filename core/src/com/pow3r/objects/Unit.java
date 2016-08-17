package com.pow3r.objects;

import com.badlogic.gdx.utils.Array;

/**
 * Created by anton on 16.04.2016.
 */
public class Unit {

    private Integer id;
    private String name;
    private Integer pow1;
    private Integer pow2;
    private Integer pow3;
    private String description;

    public Unit() {

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

    public Integer getPow1() {
        return pow1;
    }

    public void setPow1(Integer pow1) {
        this.pow1 = pow1;
    }

    public Integer getPow2() {
        return pow2;
    }

    public void setPow2(Integer pow2) {
        this.pow2 = pow2;
    }

    public Integer getPow3() {
        return pow3;
    }

    public void setPow3(Integer pow3) {
        this.pow3 = pow3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
