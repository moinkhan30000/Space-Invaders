package com.mygdx.space.hud;

public class damageTest
{
    public static void damage(hud obj)
    {

        int currentHealth= obj.getHealth();
        obj.setHealth(currentHealth-10);
    }
}
