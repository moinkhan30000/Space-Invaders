package com.mygdx.space.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.space.MainGameClass_SpaceInvaders;
import com.mygdx.space.storyline.startingStory;

public class Tutorial extends State{

    private static final int screenWIDTH= Gdx.app.getGraphics().getWidth();
    private static final  int screenHEIGHT = Gdx.app.getGraphics().getHeight();
    private Texture key;
    protected Tutorial(GameStateManager gsm) {
        super(gsm);
        key=new Texture("key.png");
    }

    @Override
    protected void handleInput()
    {

        if(Gdx.input.justTouched())
        {
            gsm.set(new startingStory(gsm));
            dispose();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            gsm.set(new MenuState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        //sb.draw(background,0,0, MainGameClass_SpaceInvaders.WIDTH,MainGameClass_SpaceInvaders.HEIGHT);
        sb.draw(key,0,0,screenWIDTH,screenHEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
