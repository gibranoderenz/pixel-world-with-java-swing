package src.tile;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public boolean collision;
    public Rectangle solidArea;

    public Tile(BufferedImage image) {
        this.image = image;
        this.collision = false;
    }
}
