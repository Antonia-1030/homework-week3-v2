package voinici;
import game.GameTile;
import java.awt.*;

public class Gard extends Piece{
    public Gard(int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = moveCol - this.col;

        return  rowCoefficient == 0 &&
                colCoefficient == 0;
    }

    public boolean isAttackValid(int attackRow, int attackCol) {
        return true;
    }
}
