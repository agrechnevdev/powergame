package com.pow3r.screens;

/**
 * Created by Anton on 27.10.2015.
 */
public enum CustomScreen {

    LEVEL_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new LevelScreen();
        }
    },

    LOGO_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new LogoScreen();
        }
    },

    START_MENU_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new StartMenuScreen();
        }
    },

    PLAY_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new PlayScreen();
        }
    },

    CHOSE_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new ChoseScreen();
        }
    };

    public abstract com.badlogic.gdx.Screen getScreenInstance();

}
