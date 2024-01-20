package com.mygdx.space.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class primaryWeapon2
{
    private Texture plasmaBeam;
    private int speed=1;
    private int coolDownPeriod;
    private int posX;
    private int posY;

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle boundsPW2;

    public Texture getPlasmaBeam() {
        return plasmaBeam;
    }

    public void setPlasmaBeam(Texture plasmaBeam) {
        this.plasmaBeam = plasmaBeam;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCoolDownPeriod() {
        return coolDownPeriod;
    }

    public void setCoolDownPeriod(int coolDownPeriod) {
        this.coolDownPeriod = coolDownPeriod;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
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

    public Rectangle getBoundsPW2() {
        return boundsPW2;
    }

    public void setBoundsPW2(Rectangle boundsPW2) {
        this.boundsPW2 = boundsPW2;
    }

    public primaryWeapon2()
    {
        plasmaBeam = new Texture("greenPlasmaBeam.png");
        boundsPW2 = new Rectangle(posX,posY,32,32);
        position = new Vector3(posX,posY,0);
        velocity = new Vector3(0,0,0);

    }

    public void update(float dt)
    {
        velocity.add(0,speed,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);

        velocity.scl(1/dt);
        boundsPW2.setPosition(getPosition().x,getPosition().y);

        if(velocity.y>2000)
        {
            velocity.y-=100;
        }
    }





    public void dispose()
    {
        plasmaBeam.dispose();
    }

    public boolean collides(Rectangle enemyShip)
    {
        return enemyShip.overlaps(boundsPW2);
    }
}
