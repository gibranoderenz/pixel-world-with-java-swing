package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import src.chars.Player;
import src.objects.SuperObject;
import src.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    // Screen settings
    private final int originalTileSize = 16;
    private final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    private final String DEFAULT_MAP_NAME = "lobby";

    private Thread gameThread;
    private KeyHandler kh = new KeyHandler();
    public TileManager tileM = new TileManager(this, DEFAULT_MAP_NAME);
    public Player player = new Player(this, kh);
    public CollisionHandler collisionHandler = new CollisionHandler(this);
    public ObjectSetter objectSetter = new ObjectSetter(this);
    public SuperObject[] objects;

    // Game FPS
    int FPS = 60;

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setDoubleBuffered(true);
        addKeyListener(kh);
        setFocusable(true);
        setBackground(Color.BLACK); // fail safe
    }

    public void setupGame() {
        objects = new SuperObject[50];
        objectSetter.setObject(tileM.mapName);
    }

    // makes the game have a loop
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // draw to screen every 0.016667 seconds
        // that means every second, we draw 60 times
        double drawInterval = 1e9 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            // update info
            update();
            // repaint graphics
            repaint();

            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1e6; // converting the remaining time to milliseconds

            if (remainingTime < 0) {
                remainingTime = 0;
            }

            try {
                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nextDrawTime += drawInterval;

        }
    }

    public void update() {
        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw tiles
        tileM.draw(g2);

        // draw additional objects (furniture, etc.)
        for (SuperObject obj : objects) {
            if (obj != null) {
                obj.draw(g2, this);
            }
        }

        // draw player
        player.draw(g2);
        g2.dispose();
    }
}
