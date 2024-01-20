package com.mygdx.space.states;


import static com.mygdx.space.sprites.particles.dParticles;
import static com.mygdx.space.sprites.particles.fParticles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.space.Abilities.regenerateHealth;
import com.mygdx.space.MainGameClass_SpaceInvaders;
import com.mygdx.space.enemyships.enemyShipWeaponArray;
import com.mygdx.space.hud.hud;
import com.mygdx.space.sprites.SpaceShip;
import com.mygdx.space.sprites.enemyShips;
import com.mygdx.space.sprites.particles;
import com.mygdx.space.weapons.primaryWeapon1;
import com.mygdx.space.weapons.primaryWeaponMechanics;

import java.util.Random;

public class playState extends State{

    private static final int particleCount = 50;
    private static final int enemyCount = 30;
    private static final int pwCount = 1;
    private static Texture exhaust;
    private static int exhaustHeight = 64;

    private static final int screenWIDTH= Gdx.app.getGraphics().getWidth();
    private static final  int screenHEIGHT = Gdx.app.getGraphics().getHeight();

    public primaryWeaponMechanics pwmObj;
    public static int enemyShipCount;

    public static SpaceShip protagonist;
    private Texture bg_playState;

    private particles obj = new particles(particleCount);
    private enemyShips enemiesObj;
    private hud hudObj = new hud();
    private BitmapFont font = new BitmapFont();
    private Texture hudContainer;
    private Texture weaponHUD;
    private regenerateHealth regObj;
    static private int flag=1;
    static private int orientationFlag=-1;
    static private int pwFlag=1;
    static private int isInvincible=-1;



    public playState(GameStateManager gsm) {
        super(gsm);
        protagonist =  new SpaceShip(100,100);
        hudContainer = new Texture("hudContainer.png");
        weaponHUD = new Texture("weaponHUD.png");
        enemiesObj = new enemyShips(enemyCount);
        pwmObj = new primaryWeaponMechanics(pwCount);
        regObj = new regenerateHealth();
        enemyShipCount = enemiesObj.enemies.size();


        exhaust=new Texture("exhaust.png");

        for (int i=0;i<particleCount;i++)
        {
            obj.particlesArr.get(i);
        }
        bg_playState =  new Texture("bg_playState2.jpg");
        cam.setToOrtho(false,MainGameClass_SpaceInvaders.WIDTH-300,MainGameClass_SpaceInvaders.HEIGHT-300);

        for(int i=0;i<enemyCount;i++)
        {
            enemiesObj.enemies.get(i).setPosition(new Vector3(new Random().nextInt(MainGameClass_SpaceInvaders.WIDTH),new Random().nextInt(300)+700,0));
            enemiesObj.enemies2.get(i).setPosition(new Vector3(new Random().nextInt(MainGameClass_SpaceInvaders.WIDTH),new Random().nextInt(500)+1000,0));
        }


        for(int i=0;i<pwCount;i++)
            pwmObj.pw1.get(i).setPosition(new Vector3(pwmObj.pw1.get(i).getPosX(),pwmObj.pw1.get(i).getPosY(),0));

        wArrObj = new enemyShipWeaponArray();
    }

    public hud obj1= new hud();
    static primaryWeapon1 weaponobj = new primaryWeapon1();

    @Override
    protected void handleInput()
    {



        if(Gdx.input.isKeyPressed(Input.Keys.D)||Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            int x = (int) protagonist.getPosition().x;
            int y = (int) protagonist.getPosition().y;
            protagonist.setPosition(new Vector3(x+5f,y,0));
            if(hudObj.getLevel()==1)
                protagonist.setProtagonist(new Texture("pShip_Right.png"));
            if(hudObj.getLevel()==2)
                protagonist.setProtagonist(new Texture("pShip2Right.png"));
            exhaustHeight=64;

        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)||Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            int x = (int) protagonist.getPosition().x;
            int y = (int) protagonist.getPosition().y;
            protagonist.setPosition(new Vector3(x-5f,y,0));
            if(hudObj.getLevel()==1)
                protagonist.setProtagonist(new Texture("pShip_Left.png"));
            if(hudObj.getLevel()==2)
                protagonist.setProtagonist(new Texture("pShip2Left.png"));
            exhaustHeight=64;
        }


        if(Gdx.input.isKeyPressed(Input.Keys.W)||Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            int x = (int) protagonist.getPosition().x;
            int y = (int) protagonist.getPosition().y;
            protagonist.setPosition(new Vector3(x,y+5f,0));
            if(hudObj.getLevel()==1)
                protagonist.setProtagonist(new Texture("pShip.png"));
            if(hudObj.getLevel()==2)
                protagonist.setProtagonist(new Texture("playerShip2.png"));
            exhaustHeight=44;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)||Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            int x = (int) protagonist.getPosition().x;
            int y = (int) protagonist.getPosition().y;
            protagonist.setPosition(new Vector3(x,y-5f,0));
            if(hudObj.getLevel()==1)
                protagonist.setProtagonist(new Texture("pShip.png"));
            if(hudObj.getLevel()==2)
                protagonist.setProtagonist(new Texture("playerShip2.png"));
            exhaustHeight=84;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            flag*=-1;

        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
        {
            pwFlag=1;
            pwmObj.pw2.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.E))
        {
            pwFlag=-1;
            pwmObj.pw1.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3))
        {
            if(regObj.getRegenerateCount()>0)
                regObj.regenerateHealth();

            if(regObj.getRegenerateCount()==0)
                System.out.println("Not enough regeneration points!");
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

        if(flag==1)
        {
            protagonist.update(dt);

            for(int i=0;i<particleCount;i++)
            {
                obj.particlesArr.get(i).update(dt);
                if(obj.particlesArr.get(i).getPosition().y<-100)
                {
                    obj.particlesArr.get(i).setPosition( new Random().nextInt(MainGameClass_SpaceInvaders.WIDTH),new Random().nextInt(700)+700);
                }
            }
            for(int i=0;i<enemiesObj.enemies.size();i++)
            {
                enemiesObj.enemies.get(i).update(dt);

                if(enemiesObj.enemies.get(i).getPosition().y<-100)
                {
                    enemiesObj.enemies.get(i).setPosition(new Vector3(new Random().nextInt(MainGameClass_SpaceInvaders.WIDTH),new Random().nextInt(1000)+700,0));
                }

                if(enemiesObj.enemies.get(i).getPosition().y<-100)
                {
                    enemiesObj.enemies2.get(i).setPosition(new Vector3(new Random().nextInt(MainGameClass_SpaceInvaders.WIDTH),new Random().nextInt(1000)+700,0));
                }
            }

            if(hudObj.getLevel() == 2)
            {
                for(int i=0;i<enemiesObj.enemies2.size();i++)
                {
                    enemiesObj.enemies2.get(i).update(dt);

                    if(enemiesObj.enemies2.get(i).getPosition().y<-100)
                    {
                        enemiesObj.enemies2.get(i).setPosition(new Vector3(new Random().nextInt(MainGameClass_SpaceInvaders.WIDTH),new Random().nextInt(1000)+700,0));
                    }
                }
            }



            if(hud.getHealth()==0)
            {
                gsm.set(new gameOver(gsm));
            }


            weaponobj.update(dt);

            if(pwFlag==1)
            {
                pwmObj.pw1.get(0).update(dt);
                if(pwmObj.pw1.get(0).getPosition().y>900)
                    pwmObj.pw1.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
                pwmObj.pw2.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
            }

            if(pwFlag==-1)
            {
                pwmObj.pw2.get(0).update(dt);
                if(pwmObj.pw2.get(0).getPosition().y>900)
                    pwmObj.pw2.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
                pwmObj.pw1.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
            }

            for(int i=0;i<enemiesObj.enemies.size();i++)
            {
                if(pwmObj.pw1.get(0).collides(enemiesObj.enemies.get(i).getBoundsES())||pwmObj.pw2.get(0).collides(enemiesObj.enemies.get(i).getBoundsES()))
                {
                    System.out.println("ENEMY HIT!");
                    pwmObj.pw1.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
                    pwmObj.pw2.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
                    enemiesObj.enemies.get(i).setNoOfHits(enemiesObj.enemies.get(i).getNoOfHits()+1);
                    hudObj.setScore(hudObj.getScore()+25);

                    if(enemiesObj.enemies.get(i).getNoOfHits()==enemiesObj.getDamageLimit())
                    {
                        System.out.println("Enemy Dead");
                        enemiesObj.enemies.remove(i);
                        System.out.println("no of enemies remaining : "+enemiesObj.enemies.size());
                        if(hudObj.getLevel()==1)
                            hudObj.setCurrency(hudObj.getCurrency()+100);

                        if(hudObj.getLevel()==2)
                            hudObj.setCurrency(hudObj.getCurrency()+200);

                        if(hudObj.getLevel()==3)
                            hudObj.setCurrency(hudObj.getCurrency()+300);

                    }
                    System.out.println(enemiesObj.enemies2.size());
                    if(enemiesObj.enemies.size()==0)
                    {
                        hudObj.setLevel(hudObj.getLevel()+1);
                        if(hudObj.getLevel()==2)
                        {
                            bg_playState = new Texture("bg_playState.jpg");
                            protagonist.setProtagonist(new Texture("playerShip2.png"));

                        }

                    }
                }

            }

            for(int i=0;i<enemiesObj.enemies.size();i++)
            {
               if(protagonist.collides(enemiesObj.enemies.get(i).getBoundsES()))
               {
                   enemiesObj.enemies.remove(i);
                   hudObj.setHealth(hudObj.getHealth()-15);
               }
               if(enemiesObj.enemies.size()==0)
               {
                   hudObj.setLevel(hudObj.getLevel()+1);
                   bg_playState= new Texture("bg_playState2.jpg");
               }
            }

            for(int i=0;i<enemiesObj.enemies2.size();i++)
            {
                if(protagonist.collides(enemiesObj.enemies2.get(i).getBoundsES()))
                {
                    enemiesObj.enemies2.remove(i);
                    hudObj.setHealth(hudObj.getHealth()-15);

                }
                if(enemiesObj.enemies2.size()==0)
                {
                    gsm.set(new gameOver(gsm));
                }
            }



            if(hudObj.getLevel()==2)
            {
                for(int i=0;i<enemiesObj.enemies2.size();i++)
                {
                    if(pwmObj.pw1.get(0).collides(enemiesObj.enemies2.get(i).getBoundsES())||pwmObj.pw2.get(0).collides(enemiesObj.enemies2.get(i).getBoundsES()))
                    {
                        System.out.println("ENEMY HIT!");
                        pwmObj.pw1.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
                        pwmObj.pw2.get(0).setPosition(new Vector3(protagonist.getPosition().x+17,protagonist.getPosition().y,0));
                        enemiesObj.enemies2.get(i).setNoOfHits(enemiesObj.enemies2.get(i).getNoOfHits()+1);
                        hudObj.setScore(hudObj.getScore()+25);

                        if(enemiesObj.enemies2.get(i).getNoOfHits()==enemiesObj.getDamageLimit())
                        {
                            System.out.println("Enemy Dead");
                            enemiesObj.enemies2.remove(i);
                            System.out.println("no of enemies remaining : "+enemiesObj.enemies2.size());
                            if(hudObj.getLevel()==1)
                                hudObj.setCurrency(hudObj.getCurrency()+100);

                            if(hudObj.getLevel()==2)
                                hudObj.setCurrency(hudObj.getCurrency()+200);

                            if(hudObj.getLevel()==3)
                                hudObj.setCurrency(hudObj.getCurrency()+300);

                        }
                        if(enemiesObj.enemies2.size()==0)
                        {

                            gsm.set(new gameOver(gsm));

                        }

                    }

                }
            }
            for(int i=0;i<enemiesObj.enemies.size();i++)
            {
                wArrObj.weaponArray.get(i).update(dt);
            }




        }
        System.out.println("Enemy ship 1 : "+enemiesObj.enemies.size()+" meow "+enemiesObj.enemies2.size());
        if(!(hudObj.getHealth()>=0))
        {
            gsm.set(new gameOver(gsm));
        }
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        //draws the background of the playState state
        sb.draw(bg_playState,0,0,MainGameClass_SpaceInvaders.WIDTH,MainGameClass_SpaceInvaders.HEIGHT);

        // draws the HUD panels
        sb.draw(hudContainer,0,650,300,130);
        sb.draw(weaponHUD,MainGameClass_SpaceInvaders.WIDTH-600,MainGameClass_SpaceInvaders.HEIGHT-1100,350,150);

        // draws all the HUD stats
        font.setColor(Color.RED);
        font.draw(sb,"Health : "+hud.getHealth().toString(),20,750);
        font.setColor(Color.WHITE);
        font.draw(sb,"Score : "+hud.getScore().toString(),160,750);
        font.setColor(Color.GREEN);
        font.draw(sb,"Currency : "+hud.getCurrency().toString(),20,700);
        font.setColor(Color.WHITE);
        font.draw(sb,"Level : "+hud.getLevel().toString(),160,700);


        //draws all the particles
        for (int i=0;i<particleCount;i++)
        {
            if(i%2==0)
                sb.draw(obj.particleTextureArr.get(i),obj.particlesArr.get(i).getPosition().x,obj.particlesArr.get(i).getPosition().y,10,10);

            else if(obj.particleTextureArr.get(i).equals(dParticles))
                sb.draw(dParticles,obj.particlesArr.get(i).getPosition().x,obj.particlesArr.get(i).getPosition().y,300,300);

            else
                sb.draw(fParticles,obj.particlesArr.get(i).getPosition().x,obj.particlesArr.get(i).getPosition().y,50,50);
        }

        for(int i=0;i<pwCount;i++)
        {
            sb.draw(pwmObj.pw1.get(i).getPlasmaBeam(),pwmObj.pw1.get(i).getPosition().x+17,pwmObj.pw1.get(i).getPosition().y,32,32);
            sb.draw(pwmObj.pw2.get(i).getPlasmaBeam(),pwmObj.pw2.get(i).getPosition().x+17,pwmObj.pw2.get(i).getPosition().y,32,32);
        }

        //draws all the enemyShips
        for(int i=0;i<enemiesObj.enemies.size();i++)
        {


            sb.draw(enemiesObj.enemies.get(i).getEnemyShip(),enemiesObj.enemies.get(i).getPosition().x,enemiesObj.enemies.get(i).getPosition().y,100,100 );

            sb.draw(wArrObj.weaponArray.get(i).getEnemyPlasma(),enemiesObj.enemies.get(i).getPosition().x+40,enemiesObj.enemies.get(i).getPosition().y+32,16,16);
        }

        for(int i=0;i<enemiesObj.enemies2.size();i++)
        {
            sb.draw(enemiesObj.enemies2.get(i).getEnemyShip(),enemiesObj.enemies2.get(i).getPosition().x,enemiesObj.enemies2.get(i).getPosition().y,100,100 );
        }



        sb.draw(exhaust,protagonist.getPosition().x+18,protagonist.getPosition().y-32,64,exhaustHeight);
        sb.draw(protagonist.getTexture(),protagonist.getPosition().x,protagonist.getPosition().y,100,100);
        sb.draw(new Texture("yourMom.jpg"),0,0,150,100);
        sb.end();
    }

    private int flagPrimaryWeapon1;
    private enemyShipWeaponArray wArrObj;


    @Override
    public void dispose() {

    }
}
