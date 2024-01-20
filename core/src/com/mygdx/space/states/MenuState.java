package com.mygdx.space.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.mygdx.space.MainGameClass_SpaceInvaders;
import com.mygdx.space.storyline.startingStory;

import java.io.IOException;

public class MenuState extends State
{
    private static final int screenWIDTH= Gdx.app.getGraphics().getWidth();
    private static final  int screenHEIGHT = Gdx.app.getGraphics().getHeight();

    private Texture background;

    private BitmapFont font = new BitmapFont();

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg5.jpg");
        font.getData().scale(1f);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched())
        {
            gsm.set(new startingStory(gsm));

            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            System.exit(0);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.C))
        {
            gsm.set(new Credit(gsm));
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.T))
        {
            gsm.set(new Tutorial(gsm));
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.S))
        {
            try {
                Process p = Runtime.getRuntime().exec(new String[] {"C:\\Users\\Anshuman\\Desktop\\Space Invaders\\assets\\Shop\\FinalShop.java"});
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(background,0,0, screenWIDTH,screenHEIGHT);
        sb.draw(new Texture("menuChoices.png"),screenWIDTH/2-new Texture("menuChoices.png").getWidth()/2,screenHEIGHT/2-new Texture("menuChoices.png").getHeight()/2);
        sb.end();
    }

    public void dispose()
    {
        background.dispose();
    }
}
