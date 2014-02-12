import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 28-May-2010
 * Time: 11:58:51 AM
 */
//menu for selecting user level
public class UserLevelMenu extends JPanel implements ActionListener {
    JTextField field;
    JLabel label;
    JButton play;
    JButton menu;
    GunMan frame;

    //creates panel and adds components
    public UserLevelMenu(GunMan frame)
    {

        this.frame = frame;
        setLayout(new BorderLayout());
        field = new JTextField();
        label = new JLabel("Level:");
        play = new JButton("Play Level");
        menu = new JButton("Main Menu");
        JPanel a = new JPanel();
        JPanel b = new JPanel();
        add(a);
        add(b,BorderLayout.SOUTH);
        a.add(label);
        a.add(field);
        b.add(play);
        b.add(menu);
        play.addActionListener(this);
        menu.addActionListener(this);

        field.setText("Insert Level Here");
    }

    //functionality of buttons
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == play)
        {
           frame.startLevel(this, field.getText());
        }
        if (e.getSource() == menu)
        {
           frame.startMenu(this);
        }
    }
}
