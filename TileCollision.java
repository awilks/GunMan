/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 22-May-2010
 * Time: 9:01:51 PM
 */

//interface for tile collison functionality
public interface TileCollision {
    //is used to get horizontal overlap
    double getXOverlap(double oldx1, double oldx2, double x1, double x2);

    // is used to get vertical overlap
    double getYOverlap(double oldy1, double oldy, double y1, double y2);
}
