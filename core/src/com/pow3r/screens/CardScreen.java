package com.pow3r.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pow3r.managers.ScreenManager;
import com.pow3r.objects.CardImage;
import com.pow3r.objects.Unit;

/**
 * Created by anton on 22.07.2016.
 */
public class CardScreen implements Screen {

    private Stage stage;
    float destiny;

    public CardScreen(Unit unit) {
        stage = new Stage(new ScreenViewport());
        this.destiny = ScreenManager.getDestiny();
        Gdx.input.setInputProcessor(this.stage);

        Texture texture = new Texture("images/card.png");
        Image image = new Image(texture);
        image.setBounds(240*destiny, 0, 360*destiny, 480*destiny);

        image.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y,
                                int pointer, int button) {
                ScreenManager.getInstance().create(CustomScreen.CHOSE_SCREEN);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                return true;
            }
        });
        image.setTouchable(Touchable.enabled);
        stage.addActor(image);

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
    }
}
