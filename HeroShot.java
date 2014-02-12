import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 18-May-2010
 * Time: 4:12:24 PM
 */
//defines functionality of a bullet shot by the hero
public class HeroShot extends Sprite{

    public double speed;

    //overides update method and stops all functionality except movement
    @Override
    public void update() {
         x+=speed;

    }
    //creates the bullet, sets its speed, and sets its image
    public HeroShot(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles,boolean dirrLeft) {
        super(locx, locy, width, height, imgs, tiles);
        speed = width*3;
        state = imgs[1];
        if(dirrLeft)
        {
            speed = -speed;
        }
    }
}
