import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel {
    public static Scene1 scene1 = new Scene1(900, 400);

    // graphics interface
    public Game() {
        setLayout(new BorderLayout());
        add(scene1);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Game");
            JPanel container = new JPanel(new BorderLayout());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(2000, 1000);

            KeyChecker keyChecker = new KeyChecker();

            // calling back-end in JPanel
            Game game = new Game();
            container.add(keyChecker);
            container.add(game);

            frame.add(container);
        
            frame.setVisible(true);
        });
    }
}
