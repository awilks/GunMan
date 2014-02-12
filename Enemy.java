import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 2-May-2010
 * Time: 12:27:13 AM
 * To change this template use File | Settings | File Templates.
 */

//defines basic characteristics of an enemy
public class Enemy extends Sprite {

    
    public boolean startInFrame;
    boolean inSpot;
    public double initX;
    public double initY;
    Hero hero;
    public int enemyType;

    //initiates enemy
    public Enemy(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles,Hero hero) {
        super(locx, locy, width, height, imgs, tiles);
        initX = locx;
        initY = locy;
        inSpot = true;
        this.hero = hero;
        
    }
    //overides default behaviour of what to do when hit by objects as inherited from Sprite class
    @Override
    public void getHit(int type) {
        super.getHit(type);
        switch(type)
            {
                case 11: health-=20;



            }
    }


    //checks if enemy is in the viewable area of the screen
    public void checkIfInFrame(Hero hero)
    {

        if (initX> hero.x - (tileW*9) && initX< hero.x + (tileW*9))
                if (initY> hero.y - (tileH*7) && initY< hero.y + (tileH*7))
                {
                    //System.out.println("startInFrame");
                    startInFrame = true;
                    if (inSpot)
                    {
                        inFrame = true;
                        inSpot = false;
                    }
                }
                else
                    startInFrame = false;
            else
                startInFrame = false;


        if (inFrame && !startInFrame)
        {
            if (x> hero.x - (tileW*9) && x< hero.x + (tileW*9))
                if (y> hero.y - (tileH*7) && y< hero.y + (tileH*7))
                    inFrame = true;
                else
                    inFrame = false;
            else
                inFrame = false;
        }

        if (!startInFrame && !inFrame && !inSpot)
        {
            x = initX;
            y = initY;
            inSpot = true;
        }

    }

    //this defines the behaviour of an enemy every time the game updates
    @Override
    public void update() {


        if (inFrame)
        {
            super.update();
            
            if (intersects(hero.x, hero.y, hero.width, hero. height))
            {

                hero.getHit(enemyType);
                System.out.println("hit");
            }
            for (int i = 0; i< hero.numBullets; i++)
            {
                if (hero.shots[i]. intersects(x,y,width,height))
                {
                    getHit(11);
                    i =hero.removeBullet(i);
                }

            }
            if (health<0)
            {
                inFrame = false;
            }
        }

    }
}
