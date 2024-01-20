package com.mygdx.space.enemyships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class enemyShipWeaponMechanics
{
    private Texture enemyPlasma;
    private int speed=-3;
    private int coolDownPeriod;
    private int posX;
    private int posY;
    private Rectangle boundsEW;

    private Vector3 position;
    private Vector3 velocity;

    public Texture getEnemyPlasma() {
        return enemyPlasma;
    }

    public void setEnemyPlasma(Texture enemyPlasma) {
        this.enemyPlasma = enemyPlasma;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Rectangle getBoundsEW() {
        return boundsEW;
    }

    public void setBoundsEW(Rectangle boundsEW) {
        this.boundsEW = boundsEW;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3 velocity) {
        this.velocity = velocity;
    }

    public enemyShipWeaponMechanics()
    {
        enemyPlasma = new Texture("EnemyWeapon.png");

        position = new Vector3(posX,posY,0);
        velocity = new Vector3(0,0,0);
        boundsEW = new Rectangle(posX,posY,32,32);
    }

    public void update(float dt)
    {
        velocity.add(0,speed,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);

        velocity.scl(1/dt);
        boundsEW.setPosition(getPosition().x,getPosition().y);

        if(velocity.y<-2000)
        {
            velocity.y+=100;
        }

    }
}
