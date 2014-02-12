import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 24-May-2010
 * Time: 3:37:38 PM
 */

//defines functionality of the main menu
public class MainMenu extends JPanel implements ActionListener {
    public JButton start = new JButton("Start");
    public JButton selectLevel = new JButton("Continue");
    public JButton userLevels = new JButton("Select User Level");
    public JButton quit = new JButton("Quit");


    public GunMan frame;
    public Scanner sc;

    //this defines the reaction to buttons being pressed
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start)
        {
           frame.startLevel(this, "map1.txt");
        }
        else if (e.getSource() == selectLevel)
        {
            try {
                sc = new Scanner(new File("save.txt"));
                frame.startLevel(this, sc.next());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        else if (e.getSource() == quit)
        {
            frame.quit();
        }
        else if (e.getSource() == userLevels)
        {
            frame.startUserMenu(this); 
        }
        



    }

    //creates menu and adds buttons and title
    public MainMenu(GunMan frame) {
        super();
        this.frame = frame;
        setLayout(new BorderLayout());
        Title a = new Title();
        JPanel b = new JPanel();
        add(a,BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);
        a.setVisible(true);
        a.repaint();
        b.add(start);
        b.add(selectLevel);
        b.add(userLevels);
        b.add(quit);
        start.addActionListener(this);
        selectLevel.addActionListener(this);
        userLevels.addActionListener(this);
        quit.addActionListener(this);

    }
}
