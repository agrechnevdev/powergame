package com.pow3r.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pow3r.game.StartGame;
import com.pow3r.objects.LogoGroundActor;

/**
 * Created by Anton on 24.10.2015.
 */
public class LogoScreen implements Screen {

    private Stage stage;
    Actor background;

    public LogoScreen(){
        stage = new Stage(new ScreenViewport());


        background = new LogoGroundActor();
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y,
                                int pointer, int button) {
               background.addAction(Actions.sequence(Actions.fadeOut(1f),Actions.run(new Runnable() {
                   @Override
                   public void run() {
                       ((Game) Gdx.app.getApplicationListener()).setScreen(new StartMenuScreen());
                   }
               })));
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {

                return true;

            }

        });
        stage.addActor(background);
        //stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(2f)));
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void show() {

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
    }

}
