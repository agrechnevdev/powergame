package com.pow3r.managers;

import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by Anton on 03.11.2015.
 */
public class GameAssetsManager extends AssetManager{

    private static GameAssetsManager instance;

    public static GameAssetsManager getInstance(){
        if(null == instance){
            instance = new GameAssetsManager();
        }
        return instance;
    }

    public void init(){}
}
