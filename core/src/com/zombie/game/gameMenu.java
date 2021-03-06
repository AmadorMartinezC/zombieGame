package com.zombie.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;

import java.awt.Button;

public class gameMenu implements Screen {

    final Zombie game;

    OrthographicCamera camera;

    public gameMenu(Zombie game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Zombie.WIDTH, Zombie.HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.sBatch.setProjectionMatrix(camera.combined);
        game.sBatch.begin();
        game.sBatch.draw(new Texture(Gdx.files.internal("menuBackground.jpg")),-20 ,-220);
        game.bMapFont.setColor(Color.RED);
        game.bMapFont.draw(game.sBatch, "MOVE THE ZOMBIE", Zombie.WIDTH / 2 - 70, Zombie.HEIGHT - 60);
        game.bMapFont.setColor(Color.WHITE);
        game.bMapFont.draw(game.sBatch, "Click the screen to start the game", Zombie.WIDTH / 2 - 120, 30);
        game.sBatch.end();

        if ( (Gdx.input.isTouched())){
            game.setScreen(new ZombieGame(game));
            dispose();
        }
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
