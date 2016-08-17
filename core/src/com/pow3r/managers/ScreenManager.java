package com.pow3r.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.utils.IntMap;
import com.pow3r.screens.CustomScreen;

/**
 * Created by Anton on 27.10.2015.
 */
public class ScreenManager {

    private static ScreenManager instance;
    private static Game game;
    public static float destiny;

    private IntMap<Screen> screens;

    private ScreenManager() {
        screens = new IntMap<Screen>();
    }

    public static float calculateDestiny(){
        float height =  Gdx.graphics.getHeight();
        float width = Gdx.graphics.getWidth();
        float destiny;
        if(width/800 > height/480)
            destiny =  height/480;
        else
            destiny =  width/800;
        if(destiny == 0)
            destiny = 1;
        return destiny;
    }



    public static ScreenManager getInstance() {
        if (null == instance) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void init(Game game) {
        this.game = game;
        destiny = calculateDestiny();
    }

    public void create(CustomScreen screen) {
        if (null == game) return;
        if (!screens.containsKey(screen.ordinal())) {
            screens.put(screen.ordinal(), screen.getScreenInstance());
        }
        game.setScreen(screen.getScreenInstance());
    }

    public void show(CustomScreen screen) {
        if (null == game) return;
        if (!screens.containsKey(screen.ordinal())) {
            screens.put(screen.ordinal(), screen.getScreenInstance());
        }
        game.setScreen(screens.get(screen.ordinal()));
    }

    public void dispose(CustomScreen screen) {
        if (!screens.containsKey(screen.ordinal())) return;
        screens.remove(screen.ordinal()).dispose();
    }

    public void dispose() {
        for (com.badlogic.gdx.Screen screen : screens.values()) {
            screen.dispose();
        }
        screens.clear();
        instance = null;
    }

    public static Game getGame() {
        return game;
    }

    public static float getDestiny() {
        return destiny;
    }
}
