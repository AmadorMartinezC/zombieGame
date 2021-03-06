package com.zombie.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zombie.game.Zombie;
import com.zombie.game.ZombieGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Zombie.WIDTH;
		config.height = Zombie.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new Zombie(), config);
	}
}
