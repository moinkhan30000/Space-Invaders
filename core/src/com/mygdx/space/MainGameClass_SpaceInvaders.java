package com.mygdx.space;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.space.states.GameStateManager;
import com.mygdx.space.states.MenuState;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MainGameClass_SpaceInvaders extends ApplicationAdapter {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static final double width = screenSize.getWidth();
	static final double height = screenSize.getHeight();

	public static final int WIDTH = (int) width;
	public static final int HEIGHT= (int) height;

	public static final int WIDTH2=2560;
	public static final int HEIGHT2=1600;

	public static final String TITLE= "Space Invaders V2";

	private GameStateManager gsm;
	public static SpriteBatch batch;

	private Music menuMusic;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		gsm= new GameStateManager();
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("mainMenuBGM_Crysis.mp3"));
		menuMusic.setLooping(true);
		menuMusic.setVolume(1f);
		menuMusic.play();
		ScreenUtils.clear(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
		System.out.println(WIDTH+"  "+HEIGHT);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	public void dispose()
	{
		super.dispose();
		menuMusic.dispose();
	}
	

}
