package com.pow3r.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.pow3r.managers.ScreenManager;
import com.pow3r.screens.CardScreen;
import com.pow3r.screens.ChoseScreen;
import com.pow3r.screens.CustomScreen;

import javafx.animation.Animation;

/**
 * Created by anton on 20.07.2016.
 */
public class CardImage extends Image {

    Texture texture;
    Unit unit;
    Texture texturePow1 = new Texture("images/blue_small.png");
    Texture texturePow2 = new Texture("images/red_small.png");
    Texture texturePow3 = new Texture("images/green_small.png");
    private Animation animation;


    public CardImage(Texture texture, float destiny, Unit unit, Stage stage) {
        super(texture);
        this.texture = texture;
        this.addListener(this.getListener(stage));
        this.setTouchable(Touchable.enabled);
        this.unit = unit;
    }

    Image combinedBackground;

    public void mergeBackground(float destiny){
        TextureRegion back = new TextureRegion(texture);
        Sprite background = new Sprite(back);
        background.setSize(texture.getWidth() * destiny, texture.getHeight() * destiny);
        background.setPosition(0,0);
        float positionX = 15;
        float positionY = 15;
        float size = 15*destiny;
        Image imagePow1 = new Image(texturePow1);
        imagePow1.setSize(size, size);
        imagePow1.setPosition(positionX, positionY);
        positionY = positionY + size * destiny;

        Image imagePow2 = new Image(texturePow2);
        imagePow2.setSize(size, size);
        imagePow2.setPosition(positionX, positionY);
        positionY = positionY + size * destiny;

        Image imagePow3 = new Image(texturePow3);
        imagePow3.setSize(size, size);
        imagePow3.setPosition(positionX, positionY);

        FrameBuffer buffer = new FrameBuffer(Pixmap.Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
        Batch batch = new SpriteBatch();

        buffer.begin();
        batch.enableBlending();
        Gdx.gl.glBlendFuncSeparate(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClearColor(1, 0, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);
        imagePow1.draw(batch, 1f);
        imagePow2.draw(batch, 1f);
        imagePow3.draw(batch, 1f);

        batch.end();
        buffer.end();

        TextureRegion combinedTexture = new TextureRegion(buffer.getColorBufferTexture());
        combinedTexture.flip(false, true);
        combinedBackground = new Image(combinedTexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        combinedBackground.setPosition(this.getX(), this.getY());
        combinedBackground.draw(batch, parentAlpha);
        //super.draw(batch, parentAlpha);
    }

    public EventListener getListener(final Stage stage) {
        return new ClickListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y,
                                int pointer, int button) {
                /*float destiny = ScreenManager.getDestiny();
                MoveToAction moveAction = new MoveToAction();
                moveAction.setPosition(240 * destiny, Gdx.graphics.getHeight());
                moveAction.setDuration(1f);
                ScaleToAction scaleToAction = new ScaleToAction();
                scaleToAction.setScale(0.3f);
                scaleToAction.setDuration(0.5f);
                event.getListenerActor().addAction(moveAction);
                event.getListenerActor().addAction(scaleToAction);*/
                ScreenManager.getGame().setScreen(new CardScreen(unit));
                stage.dispose();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                return true;
            }
        };
    }

    public Unit getUnit() {
        return unit;
    }
}
