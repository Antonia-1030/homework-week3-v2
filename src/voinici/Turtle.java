package voinici;

import game.GameTile;

import java.awt.*;
import java.util.Random;

    public class Turtle {
        private int row;
        private int col;
        private Color color;

        public Turtle(int row,int col){
            this.row = row;
            this.col = col;

        }
        //try make random turtle
        private int randomizer(){
            Random random = new Random();
            int rand = random.nextInt(5);
            while (rand==2){
                rand=random.nextInt(5);
            }
            return rand;

        }

        public void render(Graphics g) {
            int turtle1 = randomizer();
            int turtle2 = randomizer();

            g.setColor(Color.RED);
            g.drawOval((turtle1*100)+20,230,50,50);
            g.drawOval((turtle2*100)+20,230,50,50);
        }

    }
