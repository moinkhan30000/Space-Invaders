package com.mygdx.space.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class gameOver extends State
{
    private static final int screenWIDTH= Gdx.app.getGraphics().getWidth();
    private static final  int screenHEIGHT = Gdx.app.getGraphics().getHeight();

    protected gameOver(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()||Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            System.exit(0);


    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(new Texture("gameOver.jpg"),0,0,screenWIDTH,screenHEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
