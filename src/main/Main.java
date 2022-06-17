package src.main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        GamePanel gp = new GamePanel();
        gp.setupGame(); // sets the map before starting thread
        gp.startGameThread();
        window.add(gp);
        window.pack(); // fits the window to gp preferred size

        // Main window settings
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Explore Me!");
        try {
            window.setIconImage(ImageIO.read(new File("res/tiles/manor/main_floor.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}