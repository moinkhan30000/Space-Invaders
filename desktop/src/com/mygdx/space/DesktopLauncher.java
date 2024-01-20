package com.mygdx.space;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import com.mygdx.space.MainGameClass_SpaceInvaders;

//On macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setForegroundFPS(120);
		config.setTitle("Space Invaders v2");

		config.setMaximized(true);


		new Lwjgl3Application(new MainGameClass_SpaceInvaders(), config);


	}
}
