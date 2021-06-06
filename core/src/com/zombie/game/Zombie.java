package com.zombie.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Zombie extends Game {

    public static final int WIDTH = 768, HEIGHT = 576;

    public SpriteBatch batch;
    public BitmapFont font;

    @Override
    public void create(){

        batch = new SpriteBatch();

        font = new BitmapFont();

    }
}
