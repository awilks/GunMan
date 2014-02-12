import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by IntelliJ IDEA.
 * User: Adam
 * Date: 10-Apr-2010
 * Time: 11:34:36 AM
 * To change this template use File | Settings | File Templates.
 */

//the JFrame that contains all the graphics for the game
public class GunMan extends JFrame implements KeyListener {
    public GunGame gunGame;

    //creates an instance of the class
    public static void main(String[] args)
	{
		new GunMan();
	}

    //makes the JFrAME fullscreen, adds the menu, and adds keyboard functionality
	public GunMan()
	{
		super("The GAme");

		DisplayMode displayMode = new DisplayMode(800,600,32,75);
		//set fullscreen
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		//setUndecorated(true);
		//setResizable(false);
		//device.setFullScreenWindow(this);


        setSize(1000,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
        add(new MainMenu(this));

        addKeyListener(this);
        setVisible(true);


	}

    //quits game
    public void quit()
    {
        System.exit(0);
    }
    //dispalys main menu
    public void startMenu(Component c) {
        remove(c);
        setVisible(false);

        add(new MainMenu(this));

        setVisible(true);
    }

    //creates a new GunGAme object and displays the level on the screen
    public void startLevel(Component c, String levelAt) {
        remove(c);
        setVisible(false);
        gunGame = new GunGame(this);
        add(gunGame);

        setVisible(true);
        gunGame.init(levelAt);
        setVisible(true);
        setFocusable(true);
        requestFocus(true);
        gunGame.requestFocus(true);

    }

    //displays the lose screen
    public void startLoseScreen(Component c, String levelAt)
    {
        remove(c);
        setVisible(false);
        //setVisible(true);
        add(new LoseScreen(this, levelAt));

        setVisible(true);

        

    }
    public void startUserMenu(Component c)
    {
        remove(c);
        setVisible(false);
        //setVisible(true);
        add(new UserLevelMenu(this));

        setVisible(true);



    }

    //displays the win screen
    public void startWinScreen(Component c, String lastLevel)
    {
        remove(c);
        setVisible(false);
        String levelAt = "";
        int i = 0;
        while (lastLevel.charAt(i+1) != '.' || i+1 ==lastLevel.length())
        {
            i++;
            levelAt = lastLevel.substring(0,i);
            System.out.println(levelAt);
        }
        if(i+1 ==lastLevel.length() || lastLevel.charAt(i) - '0' >9)
        {
            add(new UserLevelMenu(this));
            setVisible(true);
        }


        else  {
            int levelNumber = (int)(lastLevel.charAt(i) - '0') +1;
            System.out.println(levelNumber);
            levelAt = levelAt + levelNumber + ".txt";
            if (levelNumber < 7)
            {
                add(new WinScreen(this, levelAt));
               
            }
            else
            {
                add(new EndScreen(this));
            }
            setVisible(true);
        }


    }

    //implements all the methods from the keyListener interface
    public void keyTyped(KeyEvent e) {
    }
    //sends the keyEvent when a key is pressed to the current GunGame object
    public void keyPressed(KeyEvent e) {
        if(gunGame!=null)
        {
            gunGame.keyPressed(e);
        }
    }
    //sends the keyEvent when a key is released to the current GunGame object
    public void keyReleased(KeyEvent e) {
        if(gunGame!=null)
        {
            gunGame.keyReleased(e);
        }
    }
}
