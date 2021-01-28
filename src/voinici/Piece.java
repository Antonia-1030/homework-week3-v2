package voinici;
import java.awt.*;
import game.GameTile;

public abstract class Piece {
    protected int row;
    protected int col;
    protected Color color;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g){
        int x = this.col * GameTile.FIELD_SIZE;
        int y = this.row * GameTile.FIELD_SIZE;

        g.setColor(Color.PINK);
        g.fillOval(x+20,y+30,60,60);

        g.setColor(this.color);
        g.fillOval(x+25,y+35,50,50);
    }

    public abstract boolean isMoveValid(int moveRow, int moveCol);

    public abstract boolean isAttackValid(int attackRow, int attackCol);
}
