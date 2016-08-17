package com.pow3r.objects;

/**
 * Created by anton on 17.04.2016.
 */
public class Round {

    public Integer id;
    Player player1;
    Player player2;
    Unit selectUnit1;
    Unit selectUnit2;
    Ability selectAbil1;
    Ability selectAbil2;

    public Round(Integer id) {
        this.id = id;
        Player player1 = new Player(1);
        Player player2 = new Player(2);
    }
}
