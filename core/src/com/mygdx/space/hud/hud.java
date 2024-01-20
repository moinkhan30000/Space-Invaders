package com.mygdx.space.hud;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class hud
{

    private static Integer Health;
    private static Integer Level;
    private static Integer Currency;
    private static Integer Score;

    private Label healthDisplay;
    private Label levelDisplay;
    private Label currencyDisplay;
    private Label scoreDisplay;

    public hud()
    {
        Health = 100;
        Level = 1;
        Currency = 500;
        Score = 0;
    }

    static public Integer getHealth() {
        return Health;
    }

    static public Integer getLevel() {
        return Level;
    }

    static public Integer getCurrency() {
        return Currency;
    }

    static public Integer getScore() {
        return Score;
    }


    public void setHealth(Integer health) {
        Health = health;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public void setCurrency(Integer currency) {
        Currency = currency;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public void setHealthDisplay() {
        this.healthDisplay = new Label(String.format("%03d",Health), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    }

    public void setLevelDisplay() {
        this.levelDisplay = new Label(String.format("%01d",Level), new Label.LabelStyle(new BitmapFont(), Color.WHITE));;
    }

    public void setCurrencyDisplay() {
        this.currencyDisplay = new Label(String.format("%06d",Currency), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    }

    public void setScoreDisplay() {
        this.scoreDisplay = new Label(String.format("%06d",Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    }
}
