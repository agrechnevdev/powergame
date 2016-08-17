package com.pow3r.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pow3r.game.StartGame;
import com.pow3r.managers.ScreenManager;

import java.util.List;

/**
 * Created by Anton on 25.10.2015.
 */
public class LevelScreen implements Screen {

    private Stage stage;
    float destiny;
    List<TextButton> levelButtons;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    Table levelsTable = new Table();

    public LevelScreen() {
        stage = new Stage(new ScreenViewport());
        destiny = ScreenManager.getDestiny();

        Texture texture = new Texture(Gdx.files.internal("images/game/font.png"), true);
        texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        font = new BitmapFont(Gdx.files.internal("images/game/font.fnt"), new TextureRegion(texture), false);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("images/game/menu_buttons.pack"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("button-up");
        textButtonStyle.down = skin.getDrawable("button-down");
        textButtonStyle.fontColor = Color.PURPLE;

        TextButton but = new TextButton("1", textButtonStyle);
        but.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            ;

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen());
                dispose();
            }

            ;
        });
        levelsTable.setFillParent(true);
        levelsTable.add(but).size(80 * destiny, 80 * destiny).top().left();
        stage.addActor(levelsTable);
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

    }
}
