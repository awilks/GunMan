import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 28-May-2010
 * Time: 12:38:08 PM
 */

//dispalyed when player winss all levels
public class EndScreen extends JPanel implements ActionListener {
    public JButton menu = new JButton("Main Menu");
    public GunMan frame;

    //functionality of buttons
    public void actionPerformed(ActionEvent e)   {


        if (e.getSource() == menu)
        {
            frame.startMenu(this);
        }
    }

    //creates object and adds components
    public EndScreen(GunMan frame) {
        super();
        this.frame = frame;
        setLayout(new BorderLayout());
        Title4 a = new Title4();
        JPanel b = new JPanel();
        add(a);
        add(b, BorderLayout.SOUTH);
        a.setVisible(true);

        b.add(menu);

        menu.addActionListener(this);

    }
}