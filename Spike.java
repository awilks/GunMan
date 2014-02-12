import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 21-May-2010
 * Time: 2:58:19 PM
 */

//defines functionality of a spike
public class Spike extends Enemy {
    //creates object, calls constructor for enemy, and sets image
    public Spike(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles, Hero hero) {
        super(locx, locy, width, height, imgs, tiles, hero);
        enemyType = 2;
        state = imgs[3];
    }

    //stops functionality of getHit method
    @Override
    public void getHit(int type) {
        
    }

    //checks to see if it collides with the hero
    @Override
    public void update() {
        if (inFrame)
        {
            if (intersects(hero.x, hero.y, hero.width, hero. height))
            {

                hero.getHit(enemyType);
            }
        }
    }
}
