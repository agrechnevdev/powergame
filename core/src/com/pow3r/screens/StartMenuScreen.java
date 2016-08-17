package com.pow3r.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pow3r.game.StartGame;
import com.pow3r.managers.ScreenManager;

/**
 * Created by Anton on 21.10.2015.
 */

public class StartMenuScreen implements Screen {

    private Stage stage;
    public float destiny;
    private TextButton play, exit;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;


    public StartMenuScreen (){

        stage = new Stage(new ScreenViewport());
        destiny = ScreenManager.getInstance().getDestiny();

        Skin skin = new Skin();
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("images/game/PlayExit.pack"));
        Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D,GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_LINEAR);
        Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_LINEAR);
        skin.addRegions(buttonAtlas);
        TextButton.TextButtonStyle stylePlay = new TextButton.TextButtonStyle();
        stylePlay.font = new BitmapFont();

        stylePlay.up = skin.getDrawable("button-up-play");
        stylePlay.down = skin.getDrawable("button-down-play");

        play = new TextButton("", stylePlay);

        play.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                stage.getActors().get(stage.getActors().indexOf(play, true)).addAction(
                        Actions.sequence(Actions.fadeOut(0.5f)));
                stage.getActors().get(stage.getActors().indexOf(exit, true)).addAction(
                        Actions.sequence(Actions.fadeOut(0.5f)));
                ((Game) Gdx.app.getApplicationListener()).setScreen(new LevelScreen());
            };
        });

        TextButton.TextButtonStyle styleExit = new TextButton.TextButtonStyle();
        styleExit.up = skin.getDrawable("button-up-exit");
        styleExit.down = skin.getDrawable("button-down-exit");
        styleExit.font = new BitmapFont();
        exit = new TextButton("", styleExit);
        exit.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            ;

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                dispose();
            }

            ;
        });

        play.setBounds(stage.getWidth() / 2 - play.getWidth() / 2 * destiny, stage.getHeight() / 2 + play.getHeight() / 2 * destiny, play.getWidth() * destiny, play.getHeight() * destiny);
        exit.setBounds(stage.getWidth() / 2 - exit.getWidth() / 2 * destiny, stage.getHeight() / 2 - exit.getHeight() * destiny, exit.getWidth() * destiny, exit.getHeight() * destiny);


        stage.addActor(play);
        stage.addActor(exit);
        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(2f)));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        Gdx.app.getApplicationListener().dispose();
    }
}
