package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Furniture extends SuperObject {
    public Furniture(String path) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
