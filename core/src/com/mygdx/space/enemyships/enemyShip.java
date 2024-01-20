package com.mygdx.space.enemyships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class enemyShip
{
    private int DOWNWARD=-1;
    private int level;
    private int posX;
    private int posY;
    private Rectangle boundsES;


    private Vector3 position;
    private Vector3 velocity;
    private int noOfHits;
    private Texture enemyShip;

    public float getDOWNWARD() {
        return DOWNWARD;
    }

    public int getLevel() {
        return level;
    }

    public void setDOWNWARD(int DOWNWARD) {
        this.DOWNWARD = DOWNWARD;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setBoundsES(Rectangle boundsES) {
        this.boundsES = boundsES;
    }

    public enemyShip(int type, float downward)
    {

        if(type == 1)
        {
            enemyShip = new Texture("enemyShipType1.png");
        }
        if(type == 2)
        {
            enemyShip = new Texture("enemyShipType2.png");
        }
        if(type == 3)
        {
            enemyShip = new Texture("enemyShipType3.png");
        }

        position = new Vector3(posX,posY,0);
        velocity = new Vector3(0,0,0);
        boundsES = new Rectangle(getPosition().x,getPosition().y,100,100);
        noOfHits=0;

    }

    public void update(float dt)
    {
        velocity.add(0,DOWNWARD+0.5f,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);

        velocity.scl(1/dt);
        boundsES.setPosition(getPosition().x,getPosition().y);

        if(velocity.y<-300)
        {
            velocity.y+=50;
        }


    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getEnemyShip() {
        return enemyShip;
    }

    public Rectangle getBoundsES() {
        return boundsES;
    }

    public int getNoOfHits() {
        return noOfHits;
    }

    public void setNoOfHits(int noOfHits) {
        this.noOfHits = noOfHits;
    }
}
