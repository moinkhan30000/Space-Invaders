package com.mygdx.space.sprites;

import com.mygdx.space.MainGameClass_SpaceInvaders;
import com.mygdx.space.enemyships.enemyShip;
import com.mygdx.space.enemyships.enemyShipLevel2;

import java.util.ArrayList;
import java.util.Random;

public class enemyShips
{
    private int level=1;
    private int damageLimit=7*level;
    public ArrayList<enemyShip> enemies = new ArrayList<>();
    public ArrayList<enemyShipLevel2> enemies2 = new ArrayList<>();

    public enemyShips(int count)
    {
        for(int i=0;i<count;i++)
        {
            Random rand= new Random();

            int randomX= rand.nextInt(MainGameClass_SpaceInvaders.WIDTH);
            int randomY= rand.nextInt(300)+700;
            int type=rand.nextInt(3)+1;
            float downward= -2f;

            enemies.add(new enemyShip(type,downward));
            enemies.get(i).setPosX(randomX);
            enemies.get(i).setPosY(randomY);

            enemies2.add(new enemyShipLevel2(type,downward-1f));
            enemies2.get(i).setPosX(randomX);
            enemies2.get(i).setPosY(randomY);

        }

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamageLimit() {
        return damageLimit;
    }

    public void setDamageLimit(int damageLimit) {
        this.damageLimit = damageLimit;
    }

}
