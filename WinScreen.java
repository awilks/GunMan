

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 24-May-2010
 * Time: 8:35:34 PM
 */

//menu
public class WinScreen extends JPanel implements ActionListener {
    public JButton nextLevel = new JButton("Next Level");
    public JButton menu = new JButton("Main Menu");
    public JButton save = new JButton("save");
    public GunMan frame;
    String levelAt;
    public FileWriter fw;

    //functionality of buttons
    public void actionPerformed(ActionEvent e)   {

        if (e.getSource() == nextLevel)
        {
           frame.startLevel(this, levelAt);
        }
        else if(e.getSource() == save)
        {


            try {
                fw = new FileWriter("save.txt");
            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


            try {
                System.out.println(levelAt);
                fw.write(levelAt);
                fw.close();
            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
        else if (e.getSource() == menu)
        {
            frame.startMenu(this);
        }
    }

    //creates object and adds components
    public WinScreen(GunMan frame, String levelAt) {
        super();
        System.out.println(levelAt);
        this.levelAt = levelAt;
        this.frame = frame;
        setLayout(new BorderLayout());
        Title3 a = new Title3();
        JPanel b = new JPanel();
        add(a);
        add(b, BorderLayout.SOUTH);
        a.setVisible(true);
        b.add(nextLevel);
        b.add(save);
        b.add(menu);
        nextLevel.addActionListener(this);
        save.addActionListener(this);
        menu.addActionListener(this);

    }
}