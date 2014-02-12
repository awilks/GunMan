import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 26-May-2010
 * Time: 11:43:57 PM
 */

// defines an enemy that does everything the simple enemy does and shoots
public class Infantry extends SimpleEnemy {
    Sprite[] enemies;
    Image[] imgs;
    public  int reloadTime = 15;
    int untilReload;

    //creates instance of object and defines some fields
    public Infantry(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles, Hero hero, Sprite[] enemies) {
        super(locx, locy, width, height, imgs, tiles, hero);
        this.enemies = enemies;
        state = imgs[6];
        untilReload = reloadTime;
        this.imgs = imgs;
    }

    //calls simple enemy's update method, then adds shooting mechanism
    @Override
    public void update() {
        super.update();
        if (inFrame)
        {
            untilReload--;
            if (untilReload ==0)
            {
                untilReload = reloadTime;
                int i;
                for (i =0; enemies[i]!=null; i++);
                enemies[i] = new EnemyShot(x+tileW/2,y+tileH/2,width/4,height/4,imgs, tiles, hero, vx*2, enemies);
            }
        }

    }
}
