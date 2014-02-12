import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 26-May-2010
 * Time: 6:53:46 PM
 */

//used to direct the flow of moving platforms
public class EndPoint extends Enemy {
    //initiates endPoint
    public EndPoint(double locx, double locy, double width, double height, Image[] imgs, Tile[][] tiles, Hero hero) {
        super(locx, locy, width, height, imgs, tiles, hero);
        g = 0;
        enemyType = 10;
        state = imgs[4];
    }

   
}
