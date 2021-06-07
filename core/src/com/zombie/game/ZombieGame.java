package com.zombie.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class ZombieGame extends ApplicationAdapter implements Screen {

	Zombie game;

	OrthographicCamera camera;
	private static final int FRAME_COLS = 9, FRAME_ROWS = 4, FRAME_USEFUL_COLS = 3;

	Animation<TextureRegion> walkLeft;
	Animation<TextureRegion> walkRight;
	Animation<TextureRegion> walkUp;
	Animation<TextureRegion> walkDown;

	private Texture walkSheet;
	private SpriteBatch sBatch;
	private Rectangle zombie;

	float stateTime;

	public ZombieGame(Zombie game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Zombie.WIDTH, Zombie.HEIGHT);

		sBatch = new SpriteBatch();
		walkSheet = new Texture(Gdx.files.internal("zombie_n_skeleton2.png"));

		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

		TextureRegion[] walkLeftA = new TextureRegion[FRAME_USEFUL_COLS];
		TextureRegion[] walkRightA = new TextureRegion[FRAME_USEFUL_COLS];
		TextureRegion[] walkUpA = new TextureRegion[FRAME_USEFUL_COLS];
		TextureRegion[] walkDownA = new TextureRegion[FRAME_USEFUL_COLS];

		int index;

		for  (int i = 0; i < FRAME_COLS; i++){
			index = 0;
			for(int j = 0; j < FRAME_USEFUL_COLS; j++){
				if (i == 0){walkDownA[index++] = tmp[i][j];}
				if (i == 1){walkLeftA[index++] = tmp[i][j];}
				if (i == 2){walkRightA[index++] = tmp[i][j];}
				if (i == 3){walkUpA[index++] = tmp[i][j];}
			}
		}

		walkLeft = new Animation<TextureRegion>(0.025f, walkLeftA);
		walkRight = new Animation<TextureRegion>(0.025f, walkRightA);
		walkUp = new Animation<TextureRegion>(0.025f, walkUpA);
		walkDown = new Animation<TextureRegion>(0.025f, walkDownA);

		zombie = new Rectangle();
		zombie.x = zombie.width / 2;
		zombie.y = zombie.height / 2;
		zombie.width = 30;
		zombie.height = 60;

		stateTime = 0f;

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();

		camera.update();
		game.sBatch.setProjectionMatrix(camera.combined);

		game.sBatch.begin();
		game.sBatch.draw(new Texture(Gdx.files.internal("background.jpg")), 0, 0);

		// Screen text
		game.bMapFont.draw(game.sBatch, zombie.x+"", Zombie.WIDTH / 2 - 60, Zombie.HEIGHT - 60);

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if (zombie.x < 0){
				game.sBatch.draw(walkLeft.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.x -= 0 * Gdx.graphics.getDeltaTime();
			} else {
				game.sBatch.draw(walkLeft.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.x -= 100 * Gdx.graphics.getDeltaTime();
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if (zombie.x > Zombie.WIDTH - zombie.width){
				game.sBatch.draw(walkRight.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.x += 0 * Gdx.graphics.getDeltaTime();
			} else {
				game.sBatch.draw(walkRight.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.x += 100 * Gdx.graphics.getDeltaTime();
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			if(zombie.y > Zombie.HEIGHT - 20){
				game.sBatch.draw(walkUp.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.y += 0 * Gdx.graphics.getDeltaTime();
			} else {
				game.sBatch.draw(walkUp.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.y += 100 * Gdx.graphics.getDeltaTime();
			}
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			if(zombie.y < 0){
				game.sBatch.draw(walkDown.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.y -= 0 * Gdx.graphics.getDeltaTime();
			} else {
				game.sBatch.draw(walkDown.getKeyFrame(stateTime, true), zombie.x, zombie.y);
				zombie.y -= 100 * Gdx.graphics.getDeltaTime();
			}
		}
		else{
			game.sBatch.draw(walkDown.getKeyFrames()[1], zombie.x, zombie.y, zombie.width, zombie.height);
		}

		game.sBatch.end();
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		sBatch.dispose();
	}
}
