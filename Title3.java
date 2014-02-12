import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 26-May-2010
 * Time: 10:11:20 PM
 */
//prints text
public class Title3 extends JComponent {

    //prints text
    public void paint (Graphics g)
    {
        g.setColor(Color.black);
        g.drawString("You Got The Money",getWidth()/2-40,getHeight()/2);
    }
}
