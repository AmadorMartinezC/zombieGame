package com.zombie.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class ZombieGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	Zombie game;

	// Constant rows and columns of the sprite sheet
	private static final int FRAME_COLS = 9, FRAME_ROWS = 4, FRAME_USEFUL_COLS = 3;

	// Objects used
	Animation<TextureRegion> walkLeftAnimation;
	Animation<TextureRegion> walkRightAnimation;
	Animation<TextureRegion> walkUpAnimation;
	Animation<TextureRegion> walkDownAnimation;// Must declare frame type (TextureRegion)

	private Texture walkSheet;
	private SpriteBatch spriteBatch;
	private Rectangle zombie;


	// A variable for tracking elapsed time for the animation
	float stateTime;

	public ZombieGame(Zombie game) {

		this.game = game;

		spriteBatch = new SpriteBatch();
		// Load the sprite sheet as a Texture
		walkSheet = new Texture(Gdx.files.internal("zombie_n_skeleton2.png"));


		// Use the split utility method to create a 2D array of TextureRegions. This is
		// possible because this sprite sheet contains frames of equal size and they are
		// all aligned.
		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

		TextureRegion[] walkLeft = new TextureRegion[FRAME_USEFUL_COLS];
		TextureRegion[] walkRight = new TextureRegion[FRAME_USEFUL_COLS];
		TextureRegion[] walkUp = new TextureRegion[FRAME_USEFUL_COLS];
		TextureRegion[] walkDown = new TextureRegion[FRAME_USEFUL_COLS];

		int index = 0;

		for  (int i = 0; i < FRAME_COLS; i++){
			index = 0;
			for(int j = 0; j < FRAME_USEFUL_COLS; j++){
				if (i == 0){walkDown[index++] = tmp[i][j];}
				if (i == 1){walkRight[index++] = tmp[i][j];}
				if (i == 2){walkLeft[index++] = tmp[i][j];}
				if (i == 3){walkUp[index++] = tmp[i][j];}
			}
		}

		walkLeftAnimation = new Animation<TextureRegion>(0.025f, walkLeft);
		walkRightAnimation = new Animation<TextureRegion>(0.025f, walkRight);
		walkUpAnimation = new Animation<TextureRegion>(0.025f, walkUp);
		walkDownAnimation = new Animation<TextureRegion>(0.025f, walkDown);

		zombie = new Rectangle();
		zombie.x = 800 / 2 - 64 / 2;
		zombie.y = 20;
		zombie.width = 64;
		zombie.height = 64;

		spriteBatch = new SpriteBatch();
		stateTime = 0f;

	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("zombie_n_skeleton2.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
