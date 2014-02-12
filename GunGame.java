import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 10-Apr-2010
 * Time: 11:41:53 AM
 * To change this template use File | Settings | File Templates.
 */
//an object of this class is a level of the game
public class GunGame extends JPanel implements Runnable {
    Thread thread;
    GameGraphics graphics;
    Tile[][] map;
    Hero hero;
    Sprite[] enemies;
    GunMan frame;
    String levelAt;

    

    int left = 37;
    int right =39;
    int up = 38;
    int shoot = 32;

     //instintates the object
     public  GunGame(GunMan frame)
     {

         this.frame = frame;


     }
     //defines some fields and starts the thread that runs the main game loop
     public void init(String levelAt)
     {


         thread = new Thread(this);
         
         MapCreator mapCreator = new MapCreator(levelAt, this);
         this.levelAt = levelAt;
         map = mapCreator.map;
         hero = mapCreator.hero;
         enemies = mapCreator.enemies;
         graphics = new GameGraphics(hero,map,enemies, mapCreator.tileW, mapCreator.tileH);
         setLayout(new BorderLayout());
         add(graphics);
         graphics.setVisible(true);
         graphics.init();
         graphics.repaint();
         thread.start();
         
     }


    //updates the game every 50ms by calling the update methods of all the sprotes in the level
    public void run() {
        while (hero.update(1))
        {


            //System.out.println("inloop");

            for (int i=0; enemies[i]!=null; i++)
            {
                enemies[i].checkIfInFrame(hero);
                enemies[i].update();
            }
            graphics.repaint();



            try{
                Thread.sleep(50);
            }
            catch(InterruptedException ex)
            {

            }
        }
        if (hero.wonGame)
            frame.startWinScreen(this, levelAt);
        else
            frame.startLoseScreen(this, levelAt);

    }


    //handles keyboard interaction 
    public void keyPressed(KeyEvent e) {

        //System.out.println(e.getKeyCode());
        if(e.getKeyCode() ==  left )
        {
            hero.leftDown = true;
        }
        else if(e.getKeyCode() ==  right )
        {
            hero.rightDown = true;
        }
        if(e.getKeyCode() ==  up )
        {
            hero.jumpDown = true;
        }
        if(e.getKeyCode() ==  shoot )
        {
            hero.shootDown = true;
        }
        if(e.getKeyCode() == 82)
        {
            frame.startLevel(this, levelAt);
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() ==  left )
        {
            hero.leftDown = false;
        }
        else if(e.getKeyCode() ==  right )
        {
            hero.rightDown = false;
        }
        if(e.getKeyCode() ==  up )
        {
            hero.jumpDown = false;
        }
        if(e.getKeyCode() ==  shoot )
        {
            hero.shootDown = false;
        }

    }
}
