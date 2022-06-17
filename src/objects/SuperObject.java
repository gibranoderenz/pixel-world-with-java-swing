package src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import src.main.GamePanel;

public abstract class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collisionOn = false;
    public boolean triggerChangeMap = false;
    public int x, y, width, height;
    public Rectangle solidArea = new Rectangle(); // for collision with entity
    public String type;

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, x, y, width, height,
                null);
    }
}
