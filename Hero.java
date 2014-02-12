import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 27-Apr-2010
 * Time: 2:37:29 PM
 * To change this template use File | Settings | File Templates.
 */

//defines functionaluty of the player's character
public class Hero extends Sprite {

    public boolean leftDown;
    public boolean rightDown;
    public boolean jumpDown;
    public boolean shootDown;
    int inToJump = 0;
    HeroShot[] shots = new HeroShot[3];
    int reloadTime = 5;
    int toReload = 0;
    int numBullets;
    Image[] imgs;
    double accel ;
    double maxSpeed ;
    double upAccel  ;
    double lowerBound;
  

    //updates player's speed, location, and checks for collisions
    public boolean update(int a) {

         //System.out.println("left down:" + leftDown + " rightDown:" + rightDown);
        if (health <= 0 || y>lowerBound || wonGame )
        {
            System.out.println("die");
            return false;
        }

        if (leftDown && vx>-maxSpeed)
        {
            //System.out.println("go left");
            vx-=accel;
        }
        else if (rightDown && vx<maxSpeed)
        {
            //System.out.println("go right");
            vx+=accel;
        }
        else
        {
            if(vx>0)
            {
                vx-=2*accel;
                if (vx<0)
                    vx=0;
            }
            if((vx<0))
            {
                vx +=2*accel;
                if (vx>0)
                    vx=0;
            }
        }

        if (vx<-maxSpeed)
            vx = -maxSpeed;
        else if(vx > maxSpeed)
            vx = maxSpeed;


        if(jumpDown)
        {
            //System.out.println(vy);
            if(Math.round(vy*10000) == 0 && onGround)
            {
                inToJump = 7;
                vy -= (inToJump*0.5+5)*upAccel;
                onGround = false;
                //System.out.println(vy);
                if (vy < -maxSpeed)
                    vy=-maxSpeed;
            }
            else if(inToJump>0)
            {
                inToJump--;
                vy-= (inToJump*0.5+5)+upAccel;
                if(vy < -maxSpeed)
                    vy= -maxSpeed;
            }
        }
        else
            inToJump = 0;

        if (toReload > 0)
            toReload--;

        if (shootDown && toReload ==0 && numBullets<3)
        {
            toReload = reloadTime;
            shots[numBullets] = new HeroShot(x + 0.5*width, y + 0.1*height, shotW, shotW, imgs, tiles, facingLeft );
            numBullets++;
        }


        super.update();
        //updates all the bullets shot by the hero
        for (int i = 0; i< numBullets; i++)
        {
            if (Math.abs(shots[i].x -x) > tileW*8)
            {
                i = removeBullet(i);
            }
            else
            {
                shots[i].update();
            }
        }
        return true;


    }

    // removes the bullets shot by the her ono longer needeed
    public int removeBullet(int i) {
        for(int j = i; j<numBullets-1; j++)
        {
           shots[j] = shots[j+1];
        }
        shots[numBullets-1] = null;
        numBullets--;
        i--;
        return i;
    }

//    initiates the hero and defines some fields
    public Hero(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles,double lowerBound) {
        super(locx, locy, width, height, imgs, tiles);
        state = imgs[0];
        this.imgs = imgs;
        maxSpeed = tileW*0.4;
        accel = tileW*0.15;
        upAccel = tileH*0.1;
        this.lowerBound = lowerBound;
        g = tileH *0.1;
        //onGround = true;
        health = 100;
        states = new Image[2];
        states[0] = imgs[0];
        states[1] = imgs[7];


    }
    //sets hero's location
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;

    }
    //draws the hero's state on a graphics object
    public void drawSprite(Graphics g, int locx, int locy, double offSetX, double offSetY) {
         if (!invincible || invincibleTime %2 ==0)
            g.drawImage(state, (int)(locx - 0.5*width),(int)(locy - 0.6*height),(int)width, (int)height, null);
         for (int i = 0; i < numBullets; i++)
             shots[i].drawSprite(g,offSetX,offSetY);


    }
    //switches the hero's image from left facing to right facing and vice versa
    @Override
     public void updateImage() {
        super.updateImage();
        if(vx>0)
            state = states[0];
        else if (vx<0)
            state = states[1];

    }
}
