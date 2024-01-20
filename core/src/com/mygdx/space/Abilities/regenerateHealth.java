package com.mygdx.space.Abilities;

import com.mygdx.space.hud.hud;

public class regenerateHealth
{
    private int regenerateCount;
    private hud obj = new hud();

    public regenerateHealth()
    {
        regenerateCount=5;
    }

    public int getRegenerateCount() {
        return regenerateCount;
    }

    public void setRegenerationCount(int invincibilityCount) {
        this.regenerateCount = regenerateCount;
    }

    public void regenerateHealth()
    {
        obj.setHealth(obj.getHealth()+30);
        regenerateCount--;
    }
}
