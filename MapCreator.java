import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 27-Apr-2010
 * Time: 2:56:10 PM
 * To change this template use File | Settings | File Templates.
 */

//reads in text file and creates tilemap, hero object, and a list of other sprites
public class MapCreator {
    public Tile[][] map;
    public Sprite[] enemies;
    int enemyLength = 0;
    public Hero hero;
    public Scanner sc;
    double tileW;
    double tileH;
    public TurningPoint[] turningPoints = new TurningPoint[100];
    public int turningPointLength;

    //creates list of sprites/enemies, creates hero, and creates map
    //reads in a text file containing a level design
    //uses text file to fill sprite list, set hero location, and fill tile map
    public MapCreator(String url, JPanel pane )
    {

        enemies = new Sprite[500];
        
         tileW = pane.getWidth()/15;
         //System.out.println(pane.getWidth());
         tileH = pane.getHeight()/10;

        //Toolkit toolkit = new Toolkit.getDefaultToolkit();
        //Image image = toolkit.getImage("Images\\gun.png");

        //loading graphics


        Image[] img = new Image[10];
        img[0] = new ImageIcon("Images/gun.png").getImage();
        img[1] = new ImageIcon("Images/Ground.png").getImage();
        img[2] = new ImageIcon("Images/SimpleEnemy.png").getImage();
        img[3] = new ImageIcon("Images/Spike.png").getImage();
        img[4] = new ImageIcon("Images/EndPoint.png").getImage();
        img[5] = new ImageIcon("Images/EnemyShot.png").getImage();
        img[6] = new ImageIcon("Images/Infantry.png").getImage();
        img[7] = new ImageIcon("Images/gun2.png").getImage();




        /*BufferedImaimgge[] img = new BufferedImage[10];
        try {
            img[0] = ImageIO.read(new File("C:\\Users\\Adam\\IdeaProjects\\GunMan\\src\\Images\\gun.png"));
            img[1] = ImageIO.read(new File("C:\\Users\\Adam\\IdeaProjects\\GunMan\\src\\Images\\Ground.png"));
            

        } catch (IOException e) {

        }
          */
          try{
            sc = new Scanner(new File(url));
          }
          catch (FileNotFoundException ex)
          {

              System.exit(2);
          }

        String[] lines = new String[200];
        int height = 0;
        int width = 0;
        while(sc.hasNext())
        {
            lines[height] = sc.nextLine();
            if (lines[height].length() > width)
                width = lines[height]. length();
            height++;


        }
        map = new Tile[width][height];
        hero = new Hero(0,0,tileW,tileH, img, map, height*tileH + tileH*8);
        
        for(int i = 0;i<width; i++)
            for (int j = 0; j<height; j++)
            {
                if (lines[j].length()> i)
                {
                    char code = lines[j].charAt(i);
                    if (code == 'g')
                        map[i][j] = new Ground(tileW*i,tileH*j,tileW, tileH,img[1]);
                    else if (code == 'h')
                        hero.setLocation(tileW*i,tileH*j);
                        //hero = new Hero(tileW*i,tileH*j,tileW,tileH, img, map);
                    else if (code == 's')
                    {
                        enemies[enemyLength] = new SimpleEnemy(tileW*i,tileH*j,tileW,tileH,img,map, hero);
                        enemyLength++;
                    }
                    else if (code == 'i')
                    {
                        enemies[enemyLength] = new Infantry(tileW*i,tileH*j,tileW,tileH,img,map, hero, enemies);
                        enemyLength++;
                    }
                    else if (code == '^')
                    {
                        enemies[enemyLength] = new Spike(tileW*i,tileH*j + tileH*0.2,tileW,tileH*0.8,img,map, hero);
                        enemyLength++;
                    }
                    else if(code == 'a')
                    {
                        enemies[enemyLength] = new MovingTile(tileW*i,tileH*j,tileW,tileH,img,map, hero, enemies, turningPoints,true);
                        enemyLength++;
                    }
                    else if(code == 'v')
                    {
                        enemies[enemyLength] = new MovingTile(tileW*i,tileH*j,tileW,tileH,img,map, hero, enemies, turningPoints,false);
                        enemyLength++;
                    }

                    else if(code == 't')
                    {
                        turningPoints[turningPointLength] = new TurningPoint(tileW*i,tileH*j,tileW,tileH);
                        turningPointLength++;
                    }
                    else if (code == '$')
                    {
                        enemies[enemyLength] = new EndPoint(tileW*i,tileH*j,tileW,tileH,img,map, hero);
                        enemyLength++;
                    }



                }
            }

    }
}
