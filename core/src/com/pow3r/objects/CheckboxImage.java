package com.pow3r.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by anton on 28.07.2016.
 */
public class CheckboxImage extends CheckBox {

    public CheckboxImage(String text,CheckBox.CheckBoxStyle checkBoxStyle) {
        super(text, checkBoxStyle);
        Texture textureChecked = new Texture("images/checked.png");
        Texture textureUnChecked = new Texture("images/unchecked.png");
        Image imageChecked = new Image(textureChecked);
        Image imageUnChecked = new Image(textureUnChecked);

        BitmapFont font = new BitmapFont(Gdx.files.internal("images/game/font.fnt"), new TextureRegion(new Texture(Gdx.files.internal("images/game/font.png"), false)));
        checkBoxStyle.font = font;
        checkBoxStyle.checkboxOff = imageUnChecked.getDrawable();
        checkBoxStyle.checkboxOn = imageChecked.getDrawable();

    }
}
