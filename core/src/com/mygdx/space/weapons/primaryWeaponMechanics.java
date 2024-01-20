package com.mygdx.space.weapons;

import static com.mygdx.space.states.playState.protagonist;

import com.mygdx.space.MainGameClass_SpaceInvaders;

import java.util.ArrayList;

public class primaryWeaponMechanics
{
    public ArrayList<primaryWeapon1> pw1 = new ArrayList<>();
    public ArrayList<primaryWeapon2> pw2  = new ArrayList<>();

    public primaryWeaponMechanics(int pwCount)
    {
        for (int i=0;i<pwCount;i++)
        {

            pw1.add(new primaryWeapon1());
            pw1.get(i).setPosX((int)protagonist.getPosition().x);
            pw1.get(i).setPosY((int)protagonist.getPosition().y);


            pw2.add(new primaryWeapon2());
            pw2.get(i).setPosX((int)protagonist.getPosition().x);
            pw2.get(i).setPosY((int)protagonist.getPosition().y);
        }
    }
}
