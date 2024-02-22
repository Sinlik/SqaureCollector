import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyChecker extends JPanel implements KeyListener {
    int moveRight = 0;
    final int PLAYER_SPEED = 10;
    public KeyChecker () {

        addKeyListener(this);
        setFocusable(true);
        // setFocusTraversalKeysEnabled(false);
    }

    Scene1 player = Game.scene1;

    public void keyPressed (KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (KeyEvent.getKeyText(keyCode).equals("Right")) {
            player.moveRight(PLAYER_SPEED);
        } 
        if (KeyEvent.getKeyText(keyCode).equals("Left")) {
            player.moveLeft(PLAYER_SPEED);
        }
        if (KeyEvent.getKeyText(keyCode).equals("Up")) {
            player.moveUp(PLAYER_SPEED);
        }
        if (KeyEvent.getKeyText(keyCode).equals("Down")) {
            player.moveDown(PLAYER_SPEED);
        }
        // System.out.println(player.getPositions());
        
    }
    public void keyReleased (KeyEvent e) {
        
    }
    public void keyTyped (KeyEvent e) {

    }
}