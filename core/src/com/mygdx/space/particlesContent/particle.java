package com.mygdx.space.particlesContent;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class particle
{
    public static final int downward=-1;

    private Texture star7;

    private Vector3 position;
    private Vector3 velocity;
    private int x=0;
    private int y=0;

    public Vector3 getPosition() {
        return position;
    }
    public void setPosition(int x,int y) {position=new Vector3(x,y,0);}

    public particle()
    {

        star7= new Texture("star7.png");

        position = new Vector3(x,y,0);
        velocity= new Vector3(0,0,0);
    }

    public Texture getStar7() {
        return star7;
    }

    public void update(float dt)
    {
        velocity.add(0,downward+0.3f,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);

        velocity.scl(1/dt);

        if(velocity.y<-600)
            velocity.y+=50;
    }
}
