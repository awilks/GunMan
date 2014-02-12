import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 22-May-2010
 * Time: 8:59:54 PM
 */

//defines a moving tile
public class MovingTile extends Enemy implements TileCollision {
    Hero hero;
    Sprite[] enemies;
    TurningPoint[] turningPoints;
    double speed;

    //creates moving tile and defines speed and some other fields
    public MovingTile(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles, Hero hero, Sprite[] enemies,TurningPoint[] turningPoints,boolean movingHorizontal) {
        super(locx, locy, width, height, imgs, tiles, hero);
        g = 0;
        speed = tileW*0.2;
        state = imgs[1];
        this.hero = hero;
        this.enemies = enemies;
        this.turningPoints = turningPoints;
        if (movingHorizontal)
            vx = -speed;
        else
            vy = -speed;

        movingTile = true;
        inFrame = true;

    }
    //removes check inFrame functionality
    @Override
    public void checkIfInFrame(Hero hero) {

    }

    //gets the horizontal overlap of it and another object
    public double getXOverlap(double oldx1, double oldx2, double x1, double x2)
    {

        if (oldx1 > (this.x + width))
        {
            if (x1<(this.x + width))
                return (this.x + width)-x1;
            else
                return 0;
        }
        else
        {
            if (x2 > this.x)
                return this.x - x2;
            else
                return 0;

        }
    }
    //  removes getHit functionality
    @Override
    public void getHit(int type) {
    }
    //calls update from enemy class and tries to check for collisons with hero
    @Override
     public void update() {
        super.update();
        hero.checkForTileCollision(getXOverlap(hero.oldx,hero.oldx+width,hero.x,hero.x+width), getYOverlap(hero.oldy,hero.oldy+hero.height,hero.y, hero.y+hero.height));
        int i = 0;

        while (turningPoints[i]!= null)
        {
            if (intersects(turningPoints[i].x,turningPoints[i].y, turningPoints[i].width,turningPoints[i].height))
            {
                vx = -vx;
                vy = -vy;
            }
            i++;
        }
    }

    //checks for vertical overlap with this and another object
    public double getYOverlap(double oldy1, double oldy, double y1, double y2)
    {

        if (oldy1 > (this.y + height))
        {
            if (y1<(this.y + height))
            {
                //System.out.println((this.y + height)-y1);
                return (this.y + height)-y1;
            }
            else
                return 0;
        }
        else
        {
            if (y2 > this.y)
                return this.y - y2;
            else
                return 0;

        }
    }
}
