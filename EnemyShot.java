import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 26-May-2010
 * Time: 11:23:43 PM
 */
//defines an enemy bullet
public class EnemyShot extends Enemy {
    Sprite[] enemies;
    //initiates fields of object
    public EnemyShot(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles, Hero hero, double v, Sprite[] enemies ) {
        super(locx, locy, width, height, imgs, tiles, hero);
        state = imgs[5];
        g = 0;
        vx = v;
        enemyType = 1;
        this.enemies = enemies;
        tileW = width*4;
        tileH = height*4;


    }
    //defines what the bullet does when the game updates
    @Override
    public void update() {
        super.update();
        if (vx ==0)
            inFrame =false;
        if(!inFrame)
        {
            int i;
            for (i = 0;enemies[i]!=null && enemies[i] !=this; i++ )
            {

            }
            for (int j = i; enemies[j]!=null; j++)
            {
               enemies[j] = enemies[j+1];
            }


        }


    }
}
