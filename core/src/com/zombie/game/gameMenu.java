package com.zombie.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

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

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(new Texture(Gdx.files.internal("background.jpg")),0 ,0);

        game.font.setColor(Color.BLACK);
        game.font.draw(game.batch, "Zombie Attack", 50, 550);
        game.batch.end();

        if ( (Gdx.input.isTouched())){
            game.setScreen((Screen) new gameMenu(game));
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
