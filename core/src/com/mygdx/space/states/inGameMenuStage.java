package com.mygdx.space.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class inGameMenuStage extends State
{

    private static final int screenWIDTH= Gdx.app.getGraphics().getWidth();
    private static final  int screenHEIGHT = Gdx.app.getGraphics().getHeight();
    protected inGameMenuStage(GameStateManager gsm) {
        super(gsm);
    }
    private Texture inGameMenuBG = new Texture("inGameMenuBG.jpg");

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            gsm.set(new playState(gsm));
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(inGameMenuBG,0,0,screenWIDTH,screenHEIGHT);
        sb.begin();
    }

    @Override
    public void dispose()
    {
        inGameMenuBG.dispose();
    }
}
