/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 24-May-2010
 * Time: 1:51:53 PM
 */
//used to switch direction of moving platforms
public class TurningPoint {
    public double x;
    public double y;
    public double width;
    public double height;


    //creates objects and sets location and dimensions
    public TurningPoint(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
