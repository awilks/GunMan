import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 26-May-2010
 * Time: 6:48:21 PM
 */
//prints text
public class Title2 extends JComponent {

    //prints text
    public void paint (Graphics g)
    {
        g.setColor(Color.black);
        g.drawString("You Lose",getWidth()/2-15,getHeight()/2);
    }
}
