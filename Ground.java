import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 27-Apr-2010
 * Time: 4:10:32 PM
 * To change this template use File | Settings | File Templates.
 */
//defines tile that is walked on
public class Ground extends Tile {

    //initiates object and some fields
    public Ground(double locx, double locy, double width, double height, Image img) {
        super(locx, locy, width, height, img);
        state = img;
        //System.out.println(x1 + "," + y1 + "," + width +","+height);
        
    }
}
