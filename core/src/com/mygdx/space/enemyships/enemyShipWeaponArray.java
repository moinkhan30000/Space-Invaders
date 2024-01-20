package com.mygdx.space.enemyships;

import static com.mygdx.space.states.playState.enemyShipCount;

import com.mygdx.space.sprites.enemyShips;
import com.mygdx.space.states.playState;

import java.util.ArrayList;

public class enemyShipWeaponArray
{

    public ArrayList<enemyShipWeaponMechanics> weaponArray;

    public enemyShipWeaponArray()
    {
        weaponArray = new ArrayList<>();

        for(int i=0;i<enemyShipCount;i++)
        {
            weaponArray.add(new enemyShipWeaponMechanics());
        }
    }


}
