package com.pow3r.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pow3r.managers.DatabaseManager;
import com.pow3r.managers.ScreenManager;
import com.pow3r.objects.CardImage;
import com.pow3r.objects.CheckboxImage;
import com.pow3r.objects.Unit;

/**
 * Created by anton on 19.07.2016.
 */
public class ChoseScreen implements Screen {

    Stage stage;
    float destiny;
    ScrollPane scroll;
    Table table;
    Array<Unit> listUnits;

    public ChoseScreen() {
        Viewport viewport = new ScreenViewport();
        stage = new Stage(viewport);

        this.destiny = ScreenManager.getDestiny();
        float a = Gdx.graphics.getDensity();
        Gdx.input.setInputProcessor(this.stage);
        listUnits =  DatabaseManager.getDataBase().getUnits();



        table = new Table();
        //Table container = new Table();
        scroll = new ScrollPane(table);
        for(int i = 0; i < listUnits.size; i++) {
            Texture texture = new Texture("images/card_norm.png");
            CardImage image = new CardImage(texture, destiny, listUnits.get(i), stage);
            table.add(image);
            image.mergeBackground(destiny);
            table.getCell(image).size(texture.getWidth() * destiny, texture.getHeight() * destiny).pad(20 * destiny).padBottom(10 * destiny);

            if((i+1)%4==0 && i != 0) {
                table.row();
                for(int j = 0; j < 4; j++){
                    CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle();
                    CheckboxImage checkBox = new CheckboxImage("", checkBoxStyle);
                    table.add(checkBox);
                    table.getCell(checkBox).size(30*destiny).padBottom(10 * destiny);
                }
                table.row();
            }
        }
        scroll.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(scroll);
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
