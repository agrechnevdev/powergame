package com.pow3r.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Anton on 24.10.2015.
 */
public class LogoGroundActor extends Actor {

    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    public LogoGroundActor() {
        backgroundTexture = new Texture("images/sky.jpg");
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        setTouchable(Touchable.enabled);
    }

    @Override
    public void draw(Batch batch, float alpha) {
        backgroundSprite.draw(batch);
    }
}
