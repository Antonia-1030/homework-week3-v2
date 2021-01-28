package window;
import game.GameBoard;

import javax.swing.*;
import java.awt.*;

//make window
public class Window extends JDialog{
    public Window( JFrame parent, String title, String message ) {
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
//visualize window
    public static void render(JFrame parent, String title, String message) {
        new Window(parent, title, message);
    }
//win message visualization
    public static void win(JFrame parent, String title, String message, String s) {
    }
}

