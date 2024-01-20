package com.mygdx.space.storyline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.space.MainGameClass_SpaceInvaders;
import com.mygdx.space.states.GameStateManager;
import com.mygdx.space.states.MenuState;
import com.mygdx.space.states.State;
import com.mygdx.space.states.playState;

import java.util.ArrayList;

public class startingStory extends State
{
    private Texture storyLineSlide;
    private Texture startingStoryBG;

    private static final int screenWIDTH= Gdx.app.getGraphics().getWidth();
    private static final  int screenHEIGHT = Gdx.app.getGraphics().getHeight();

    public startingStory(GameStateManager gsm) {
        super(gsm);
        storyLineSlide = new Texture("storyLineFront.png");
        startingStoryBG = new Texture("storyLine.jpg");


    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            gsm.set(new playState(gsm));
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            gsm.set(new MenuState(gsm));
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(startingStoryBG,0,0, screenWIDTH,screenHEIGHT);
        sb.draw(storyLineSlide,10,20,500,1000);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
