import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 10-Apr-2010
 * Time: 11:52:33 AM
 * To change this template use File | Settings | File Templates.
 */
//defines base functionality for all objects(except tiles) in the game
public class Sprite {
    boolean facingLeft;
    public Image state;
    public Image[] states;
    public double height;
    public double width;
    public double x;
    public double y;
    double oldx;
    double oldy;
    public double vx;
    public double vy;
    double tileW;
    double tileH;
    Tile[][] tiles;
    double g = 2.2;
    double shotW ;
    boolean wonGame;
    boolean movingTile;

    public boolean inFrame;
    public boolean onGround;

    int health;
    boolean invincible;
    int invincibleTime;


    //creates object and sets location and dimensions
   public Sprite(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles)
   {
       x = locx;

        y = locy;

        this.width = width;
        this.height = height;
        tileW = width;
        tileH = height;
       this.tiles = tiles;
       shotW = tileW*0.2;
   }

   //checks to see if it intersects with another object
   public boolean intersects(double x, double y, double width, double height)
   {
       Rectangle rect1 = new Rectangle((int)(x*100),(int)(y*100),(int)(width*100),(int)(height*100));
       Rectangle rect2 = new Rectangle((int)(this.x*100),(int)(this.y*100),(int)(this.width*100),(int)(this.height*100));

       if(rect1.intersects(rect2))
            return true;
       else
            return false;


   }
   //does nothing now, but is overidden in other classes
   public void checkIfInFrame(Hero hero)
   {

   }

  

   //updates speed, location, invincibility, direction
   public void update()
   {

       //set facing direction
       if (vx<0)
       {
           facingLeft = true;
       }
       else if(vx > 0)
       {
           facingLeft = false;
       }


       if (invincible)
       {
           invincibleTime--;
           if (invincibleTime ==0)
               invincible = false;
       }
       // applying gravity

       vy += g;

       // moving 
       oldx = x;
       oldy = y;
       x+=vx;
       y+=vy;
       if(!movingTile)
        checkForTiles();


       updateImage();
   }

    //checks all the tiles in the area of the sprite for collisons
    private void checkForTiles() {
        // collision detection for tiles
        int startTileX = (int)((x)/tileW) - 2;
        int startTileY = (int)((y)/tileH) - 2 ;


        for (int i = 0; i<4; i++)
            for(int j = 0; j < 4; j++)
            {
                int tilex = i + startTileX;
                int tiley = j + startTileY;
                if(tilex>=0 && tilex<tiles.length && tiley<tiles[tilex].length && tiley>=0   && tiles[tilex][tiley]!=null)
                {
                    double xOverlap = tiles[tilex][tiley].getXOverlap(oldx, oldx + width, x, x + width);
                    double yOverlap = tiles[tilex][tiley].getYOverlap(oldy, oldy + height, y, y +height);

                    //System.out.println(xOverlap + "," + yOverlap);
                    checkForTileCollision(xOverlap, yOverlap);
                }
            }
    }

    //checks a tile for a collison and fixes location and speed if there is one
    public void checkForTileCollision(double xOverlap, double yOverlap) {
        if (Math.abs(xOverlap)>0.01 && Math.abs(yOverlap)>0.01)
        {
            if (yOverlap <0)
                    onGround = true;
            //Need Fix for backwards collison
            //System.out.println(xOverlap +","+yOverlap);
            if(yOverlap<-g+0.01 &&yOverlap >-g-0.01)  //fixes backward collison
            {
                //System.out.println("good fix");
                y+=yOverlap+0.00000001;
                if(yOverlap>0)
                    vy = g;

                else
                {
                    vy = 0;
                    //System.out.println("fick");
                }
            }
            else if (Math.abs(xOverlap)<Math.abs(yOverlap))
            {






                //System.out.println(xOverlap + "," + yOverlap);
                x+=xOverlap+0.0001;
                vx = 0;
            }
            else
            {
                y+=yOverlap+0.00000001;
                if(yOverlap>0)
                    vy = g;
                else
                {
                    vy = 0;
                    onGround =true;
                }
            }

        }
    }

    //no functionality yet, but is overidden in other classes
    public void updateImage()
    {

    }

    //draws the image referenced by state in a graphics object
    public void drawSprite(Graphics g, double heroX, double heroY)
    {
        g.drawImage(state, (int)(x-heroX), (int)(y-heroY),(int)width,(int)height,null);
        //System.out.println(state+","+ (int)(x-heroX)+","+ (int)(y-heroY)+","+(int)width+","+(int)height);
    }
    //defines what happens when the sprite collides with different objects
    public void getHit(int type)
    {   if (!invincible)
            switch(type)
            {
                case 1: health-=20;
                System.out.println(health);    
                invincible = true;
                invincibleTime = 20;
                break;
                case 2: health -=80;
                     invincible = true;
                invincibleTime = 20;
                break;
                case 10:
                    wonGame = true;
                    break;

            }
         if (type == 10)
             wonGame = true;
                
    }
}
