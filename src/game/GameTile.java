package game;
import javax.swing.*;
import java.awt.*;

public class GameTile extends JFrame{
    private int row;
    private int col;
    public static final int FIELD_SIZE=100;
    //board setting
    public GameTile(int row, int col){
        this.row= row;
        this.col= col;
        setBackground(Color.WHITE);
    }
    //red
    public void redTile(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        g.fillRect(400, 0, 100, 100);
        g.fillRect(100, 400, 100, 100);
        g.fillRect(300, 400, 100, 100);
    }
    //blacl
    public void blackTile(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(100,0,100,100);
        g.fillRect(300,0,100,100);
        g.fillRect(0,400,100,100);
        g.fillRect(400,400,100,100);
    }
    //gray
    public void grayTile(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0,100,100,100);
        g.fillRect(100,100,100,100);
        g.fillRect(300,100,100,100);
        g.fillRect(400,100,100,100);

        g.fillRect(0,300,100,100);
        g.fillRect(100,300,100,100);
        g.fillRect(300,300,100,100);
        g.fillRect(400,300,100,100);
    }
    //finish
    public void dotTile(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillOval(225,225,50,50);
    }
}
