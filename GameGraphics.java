import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 27-Apr-2010
 * Time: 2:30:14 PM
 * To change this template use File | Settings | File Templates.
 */

//this class handles all of the graphics during a game
public class GameGraphics extends JComponent {
    public Hero hero;
    public Tile[][] tiles;
    public Sprite[] enemies;
    double tileW;
    double tileH;
     BufferedImage[] img;
    double offSetX;
    double offSetY;

    //initiates object and some fields
    public GameGraphics(Hero hero, Tile[][] tiles, Sprite[] enemies, double w, double h) {
        this.hero = hero;
        this.tiles = tiles;
        this.enemies = enemies;
        tileW = w;
        tileH = h;


    }

    //paints the screen
    public void init()
    {

         repaint();
    }

    //defines what is drawn on the screen
    public void paint(Graphics g)
    {
        //paint background
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth()+10,getHeight()+10);
        offSetX = hero.x-(getWidth()/2 - 0.5*hero.width);
        offSetY= hero.y-(getHeight()/2-0.5*hero.width);
        int z = 0;
        //System.out.println("dfsfad");
        for (int i=0; enemies[i]!=null; i++)
        {
                //System.out.println("in");
                if (enemies[i].inFrame)
                    enemies[i].drawSprite(g, offSetX, offSetY);
        }
        hero.drawSprite(g, getWidth()/2, getHeight()/2, offSetX, offSetY);
        int startTileX = (int)(hero.x/tileW) - 8;
        int startTileY = (int)(hero.y/tileH) - 6 ;
        for (int i = 0; i<17; i++)
            for(int j = 0; j < 13; j++)
            {
                int tilex = i + startTileX;
                int tiley = j + startTileY;
                if(tilex>=0 && tilex<tiles.length && tiley<tiles[tilex].length && tiley>=0   && tiles[tilex][tiley]!=null)
                {
                    //System.out.println(tilex+","+tiley);
                    z++;
                    tiles[tilex][tiley].drawTile(g,offSetX,offSetY);
                    //System.out.println((hero.x-(getWidth()/2)) + "," + (hero.y-(getHeight()/2)));
                    //System.out.println(z);
                }
            }
         g.setColor(Color.red);
         g.fillRect(10,10,5,hero.health);

      
    }

}
