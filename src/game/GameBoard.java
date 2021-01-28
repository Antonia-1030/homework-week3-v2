package game;

import voinici.*;
import window.Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {
    private Object selectedPiece;
    private Object[][] pieceCollection=new Object[5][5];
    public static boolean isGameOver=false;
    public static int movesMade=0;


    public GameBoard() {
        //green
        this.pieceCollection[4][0]=(new Lider(4,0,Color.GREEN));
        this.pieceCollection[4][1]=(new Gard(4,1,Color.GREEN));
        this.pieceCollection[4][2]=(new Gard(4,2,Color.GREEN));
        this.pieceCollection[4][3]=(new Gard(4,3,Color.GREEN));
        this.pieceCollection[4][4]=(new Gard(4,4,Color.GREEN));

        //yellow
        this.pieceCollection[0][0]=(new Lider(0,0,Color.YELLOW));
        this.pieceCollection[0][1]=(new Gard(0,1,Color.YELLOW));
        this.pieceCollection[0][2]=(new Gard(0,2,Color.YELLOW));
        this.pieceCollection[0][3]=(new Gard(0,3,Color.YELLOW));
        this.pieceCollection[0][4]=(new Gard(0,4,Color.YELLOW));

        //size and close
        this.setSize(500, 500);
        this.setVisible(true);
        this.addMouseListener(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimension(e.getY());
        int col = this.getBoardDimension(e.getX());

        // check if correct
        if (this.selectedPiece != null) {
            // TODO: change position
            Piece p = (Piece) this.selectedPiece;
            if(p.isMoveValid(row, col)) {
                movePiece(row, col, p);
                this.repaint();
                //finish?
                if(row==3 && col==3){
                    isGameOver=true;
                    gameOverMessage();
                }
                return;
            }
        }
        else {
            Window.render(this, "Error!","Invalid move!");
            return;
        }

        if (this.isFull(row, col)) {
            this.selectedPiece = this.getPiece(row, col);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        //visualize board and piece
        super.paint(g);
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                GameTile tile = new GameTile(row, col);
                tile.redTile(g);
                tile.blackTile(g);
                tile.grayTile(g);
                tile.dotTile(g);
                tile.setBackground(Color.WHITE);
                this.renderGamePiece(g, row, col);
                Turtle t=new Turtle(row,col);
                t.render(g);
            }
        }
    }
    public void gameOverMessage(){
        boolean isGreenTurn=true;
        do{
            if (isGreenTurn){
                movesMade++;
            }
            isGreenTurn=!isGreenTurn;

        } while (!isGameOver);
        //displayed message when won
        Window.win(this, "Congrats","Winner is %s!",isGreenTurn?"Green":"Yellow");
    }

    private void movePiece(int row, int col, Piece p) {
        // get initial place
        int initialRow = p.getRow();
        int initialCol = p.getCol();

        // move the piece to new coordinates
        p.move(row, col);

        // TODO: Abstraction of piece collection
        this.pieceCollection[p.getRow()][p.getCol()] = this.selectedPiece;
        this.pieceCollection[initialRow][initialCol] = null;

        // delete old coordinates
        // TODO: Abstraction of selected piece access
        this.selectedPiece = null;
    }

    private int getBoardDimension(int coordinates) {
        return coordinates / GameTile.FIELD_SIZE;
    }

    private boolean isFull(int row, int col) {
        return this.getPiece(row, col) != null;
    }

    private Object getPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    private void renderGamePiece(Graphics g, int row, int col) {

        if(this.isFull(row, col)) {

            Piece p = (Piece) this.getPiece(row, col);
            p.render(g);
        }
    }
}
