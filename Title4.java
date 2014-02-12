import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 28-May-2010
 * Time: 12:42:15 PM
 */
//prints text
public class Title4 extends JComponent {

    //prints text
    public void paint (Graphics g)
    {
        g.setColor(Color.black);
        g.drawString("The End",getWidth()/2-30,getHeight()/2);
    }
}
