package com.mygdx.space.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SpaceShip
{
    private static final int UPWARD = 0;
    private static final int RIGHTWARD = 0;

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle spaceBounds;
    private Texture protagonist;

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Texture getSpaceship() {
        return protagonist;
    }

    public Rectangle getSpaceBounds() {
        return spaceBounds;
    }

    public void setSpaceBounds(Rectangle spaceBounds) {
        this.spaceBounds = spaceBounds;
    }

    public SpaceShip(int x, int y)
    {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        protagonist = new Texture("pShip.png");
        spaceBounds= new Rectangle(getPosition().x,getPosition().y,100,100);

    }

    public void update(float dt)
    {
        velocity.add(RIGHTWARD,UPWARD,0);
        velocity.scl(dt);
        position.add(velocity.x,velocity.y,0);
        spaceBounds.setPosition(getPosition().x,getPosition().y);

        velocity.scl(1/dt);
    }

    public Texture getTexture() {
        return protagonist;
    }

    public boolean collides(Rectangle enemyShip)
    {
        return enemyShip.overlaps(spaceBounds);
    }

    public void setProtagonist(Texture protagonist) {
        this.protagonist = protagonist;
    }
}
