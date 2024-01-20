package com.mygdx.space.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.space.MainGameClass_SpaceInvaders;
import com.mygdx.space.particlesContent.particle;

import java.util.ArrayList;
import java.util.Random;

public class particles
{

    public ArrayList<particle> particlesArr = new ArrayList<>();
    public ArrayList<Texture> particleTextureArr = new ArrayList<>();

    public static Texture dParticles = new Texture("dParticles.png");
    public static Texture fParticles = new Texture("fparticles.png");


    public particles(int count)
    {

        for(int i=0;i<count;i++)
        {
            Random rand= new Random();

            int randomY = rand.nextInt(300)+700;
            int randomX= rand.nextInt(MainGameClass_SpaceInvaders.WIDTH);
            int choices= rand.nextInt(3);

            particlesArr.add(new particle());
            particlesArr.get(i).setPosition(randomX,randomY);

            if(choices+1==1)
                particleTextureArr.add(particlesArr.get(i).getStar7());


            if(choices+1==2)
                particleTextureArr.add(dParticles);


            if(choices+1==3)
                particleTextureArr.add(fParticles);


        }
    }
}
