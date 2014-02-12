import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 24-May-2010
 * Time: 3:42:23 PM
 */

//prints text
public class Title extends JComponent {
    //prints text
    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.black);
        g.drawString("Gun Man", getWidth()/2 - 15,getHeight()/2);
    }
}
