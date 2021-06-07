package com.zombie.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Zombie extends Game {

    public static final int WIDTH = 550, HEIGHT = 400;

    public SpriteBatch sBatch;
    public BitmapFont bMapFont;

    @Override
    public void create(){

        sBatch = new SpriteBatch();

        bMapFont = new BitmapFont();
        this.setScreen(new gameMenu(this));

    }
}
