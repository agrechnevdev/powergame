package com.pow3r.game;

import com.badlogic.gdx.Game;
import com.pow3r.managers.DataBase;
import com.pow3r.managers.DatabaseManager;
import com.pow3r.managers.ScreenManager;
import com.pow3r.objects.Unit;
import com.pow3r.screens.CustomScreen;

public class StartGame extends Game {

	public DataBase dataBase;

	public StartGame(DataBase dataBase){
		this.dataBase = dataBase;

	}

	@Override
	public void create () {
		DatabaseManager.getInstance().init(dataBase);
		ScreenManager.getInstance().init(this);
		ScreenManager.getInstance().show(CustomScreen.CHOSE_SCREEN);
	}

	@Override
	public void render () {
		super.render();
	}

	public DataBase getDataBase() {
		return dataBase;
	}
}
