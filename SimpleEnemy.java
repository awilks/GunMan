import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 2-May-2010
 * Time: 9:48:45 AM
 */

//defines functionality of a enemy that walks back and forth on a platform
public class SimpleEnemy extends Enemy{
    boolean goingLeft;
    double speed;

    // creates instance and defines some fields
    public SimpleEnemy(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles, Hero hero) {
        super(locx, locy, width, height, imgs, tiles, hero);
        state = imgs[2];
        speed = tileW*0.25;
        health = 40;
        enemyType = 1;
    }

    // if it is on screen schecks if it needs to change direction then calls update method from enemy class
    @Override
    public void update() {
        //System.out.println(x+","+y);
        if (inSpot)
            goingLeft = true;
        if (inFrame)
        {
            int xTile = (int)(x/tileW);
            int yTile = (int) (y/tileH)+1;


            //System.out.println(xTile+ "," + yTile);
            if(goingLeft)
            {

               if (xTile-1 < 0 ||yTile>=tiles[0].length|| tiles[xTile][yTile] ==null )
                   goingLeft = false;
            }
            else
                if ( xTile+1>=tiles.length || yTile>=tiles[0].length|| tiles[xTile+1][yTile] ==null )
                   goingLeft = true;



            //update speed
            if(goingLeft)
                vx = -speed;
            else
                vx = speed;
        }


        super.update();
        if (vx == 0)
        {
            goingLeft = !goingLeft;
        }
    }
}
