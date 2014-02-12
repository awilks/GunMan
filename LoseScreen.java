

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 24-May-2010
 * Time: 8:35:34 PM
 */

//defines  the screen displays when user dies in a level
public class LoseScreen extends JPanel implements ActionListener {
    public JButton retry = new JButton("Retry");
    public JButton menu = new JButton("Main Menu");
    public JButton save = new JButton("save");
    public GunMan frame;
    String levelAt;
    public FileWriter fw;

    //defines actions taken when buttons are clicked
    public void actionPerformed(ActionEvent e)   {

        if (e.getSource() == retry)
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

    //creates lose screen and adds buttons and title
    public LoseScreen(GunMan frame, String levelAt) {
        super();
        this.levelAt = levelAt;
        this.frame = frame;
        setLayout(new BorderLayout());
        Title2 a = new Title2();
        JPanel b = new JPanel();
        add(a);
        add(b, BorderLayout.SOUTH);
        a.setVisible(true);
        b.add(retry);
        b.add(save);
        b.add(menu);
        retry.addActionListener(this);
        save.addActionListener(this);
        menu.addActionListener(this);

    }
}
