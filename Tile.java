import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 21-Apr-2010
 * Time: 2:57:07 PM
 * To change this template use File | Settings | File Templates.
 */

//defines base functionality of tiles
public class Tile implements TileCollision {
    public double x1;
    public double x2;
    public double y1;
    public double y2;
    public double width;
    public double height;
    public Image state;
    //creates tile and sets dimensions, location, and image
    public Tile (double locx, double locy,double width, double height, Image img)
    {
        x1 = locx;
        x2 = locx + width;
        y1 = locy;
        y2 = locy + height;
        this.width = width;
        this.height = height;
        state = img;
    }

    //finds horizontal overalap
    public double getXOverlap(double oldx1, double oldx2, double x1, double x2)
    {

        if (oldx1 > this.x2)
        {
            if (x1<this.x2)
                return this.x2-x1;
            else
                return 0;
        }
        else
        {
            if (x2 > this.x1)
                return this.x1 - x2;
            else
                return 0;

        }
    }

    //findsvertical overlap between this and a sprite
    public double getYOverlap(double oldy1, double oldy, double y1, double y2)
    {

        if (oldy1 > this.y2)
        {
            if (y1<this.y2)
            {
                //System.out.println(this.y2-y1);
                return this.y2-y1;
            }
            else
                return 0;
        }
        else
        {
            if (y2 > this.y1)
                return this.y1 - y2;
            else
                return 0;

        }
    }

    //draws image to graphics object
    public void drawTile(Graphics g, double heroX, double heroY)
    {
        g.drawImage(state, (int)(x1-heroX), (int)(y1-heroY),(int)width,(int)height,null);
        //System.out.println((int)(x1-heroX)+"," +(int)(y1-heroY)+","+(int)width+","+(int)height);
    }

    
}
