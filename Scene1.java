import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import java.util.*;

public class Scene1 extends JPanel {
    Random random = new Random();
    int NUM_TREES = 10;
    int posX;
    int posY;
    int points = 0;
    int playerArea = 100;
    boolean win = false;
    ArrayList<Color> treeColor = new ArrayList<>();
    ArrayList<Integer> treePosX = new ArrayList<>();
    ArrayList<Integer> treePosY = new ArrayList<>();
    ArrayList<Integer> NEWtreePosX = new ArrayList<>();
    ArrayList<Integer> NEWtreePosY = new ArrayList<>();
    @Override
    // creates the player color and positioning
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < NUM_TREES; i++) {
            tree(treePosX.get(i), treePosY.get(i), g, i, treeColor.get(i));
            if ((posX > treePosX.get(i) - playerArea) && (posX < treePosX.get(i) + (playerArea - 50))
                && (posY > treePosY.get(i) - playerArea) && (posY < treePosY.get(i) + (playerArea - 50))) {
                // treeColor.set(i, Color.GRAY);
                treePosX.set(i, -100);
                repaint();
                points++;
                System.out.printf("You scored another points at (X: %d, Y: %d)\n Points = %d\n", posX, posY, points);
            }
        }
        if (posX > 1850) {
            posX = 1849;
        }
        if (posX < 0) {
            posX = 1;
        }
        if (posY < 0) {
            posY = 1;
        }
        if (posY > 1000) {
            posY = 1000;
        }

        if (points == NUM_TREES) {
            points = 99999;
            win = true;
        }
        if (win == true) {
            System.out.println("You won with " + points + " points!");
        }
        player(posX, posY, g);
    }
    // when called, allows for a empty decloration
    public Scene1 () {
        
    }
    public void generateTreePos () {
        int treePosXPt = 0;
        int treePosYPt = 0;
        for (int run = 0; run < 3; run++) {
            
        }
        for (int i = 0; i < NUM_TREES; i++) {
            treePosXPt = random.nextInt(1900);
            treePosYPt = random.nextInt(1000);
            treePosX.add(treePosXPt);
            treePosY.add(treePosYPt);
            treeColor.add(Color.GREEN);

            System.out.printf("treePosX = %d. treePosY = %d. I: %d\n", treePosX.get(i), treePosY.get(i), i);
           
        }    
            System.out.println("\n\n");
        }
        // System.out.printf("i = %d\n", treePosX.get(2));

    
    // creates position for the player
    public Scene1 (int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        generateTreePos();
    }
    public void moveRight (int speed) {
        this.posX += speed;
        repaint();
    }
    public void moveLeft (int speed) {
        this.posX -= speed;
        repaint();
    }
    public void moveUp (int speed) {
        this.posY -= speed;
        repaint();
    }
    public void moveDown (int speed) {
        this.posY += speed;
        repaint();
    }
    public int getPosX () {
        return posX;
    }
    public int getPosY () {
        return posY;
    }
    public String getPositions () {
        String returnString = "X: " + posX + " Y: " + posY;
        return returnString;
    }

    public void player (int x, int y, Graphics g) {
        g.setColor(Color.red);
        g.fillRect(posX, posY, 100, 100);
        
        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.PLAIN, 20));
        g.drawString(Integer.toString(points), x + 20, y + 50);
    }
    public void tree (int x, int y, Graphics g, int i, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Courier", Font.PLAIN, 20));
        g.drawString(Integer.toString(i), x + 15, y + 30);
    }
}