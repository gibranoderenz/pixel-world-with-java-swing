package src.chars;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;
import src.main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler kh;

    public Player(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 5 * gp.tileSize;
        y = 7 * gp.tileSize;
        scale = 3;
        speed = 4;
        direction = "down";
        solidArea = new Rectangle();
        // hardcoded, but gets the job done for this player.
        solidArea.x = x + 57;
        solidArea.y = y + 64;
        solidArea.width = 32;
        solidArea.height = 48;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/up/up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/up/up4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/up/up5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/up/up6.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/down/down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/down/down4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/res/player/down/down5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/res/player/down/down6.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/left/left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/left/left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/res/player/left/left5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/res/player/left/left6.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/right/right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/right/right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/res/player/right/right5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/res/player/right/right6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // update values only when player is moving
        if (kh.upPressed || kh.downPressed || kh.leftPressed || kh.rightPressed) {
            // set player direction based on key pressed
            if (kh.upPressed) {
                direction = "up";
            } else if (kh.downPressed) {
                direction = "down";
            } else if (kh.leftPressed) {
                direction = "left";
            } else if (kh.rightPressed) {
                direction = "right";
            }

            // check collisions: allow movement if collision does not occur
            collisionOn = gp.collisionHandler.checkTile(this) || gp.collisionHandler.checkObject(this);
            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        y -= speed;
                        solidArea.y -= speed;
                        break;
                    case "down":
                        y += speed;
                        solidArea.y += speed;
                        break;
                    case "left":
                        x -= speed;
                        solidArea.x -= speed;
                        break;
                    case "right":
                        x += speed;
                        solidArea.x += speed;
                        break;
                }

            }

            // player animation: update sprite only when moving the player
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum < 6) {
                    spriteNum += 1;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        // draw to screen
        BufferedImage image = null;

        switch (this.direction) {
            case "up":
                if (kh.upPressed) {
                    if (spriteNum == 1) {
                        image = up1;
                    } else if (spriteNum == 2) {
                        image = up2;
                    } else if (spriteNum == 3) {
                        image = up3;
                    } else if (spriteNum == 4) {
                        image = up4;
                    } else if (spriteNum == 5) {
                        image = up5;
                    } else if (spriteNum == 6) {
                        image = up6;
                    }
                } else {
                    // default sprite when idle
                    image = up3;
                }
                break;
            case "down":
                if (kh.downPressed) {
                    if (spriteNum == 1) {
                        image = down1;
                    } else if (spriteNum == 2) {
                        image = down2;
                    } else if (spriteNum == 3) {
                        image = down3;
                    } else if (spriteNum == 4) {
                        image = down4;
                    } else if (spriteNum == 5) {
                        image = down5;
                    } else if (spriteNum == 6) {
                        image = down6;
                    }
                } else {
                    // default sprite when idle
                    image = down3;
                }
                break;
            case "left":
                if (kh.leftPressed) {
                    if (spriteNum == 1) {
                        image = left1;
                    } else if (spriteNum == 2) {
                        image = left2;
                    } else if (spriteNum == 3) {
                        image = left3;
                    } else if (spriteNum == 4) {
                        image = left4;
                    } else if (spriteNum == 5) {
                        image = left5;
                    } else if (spriteNum == 6) {
                        image = left6;
                    }
                } else {
                    // default sprite when idle
                    image = left3;
                }
                break;
            case "right":
                if (kh.rightPressed) {
                    if (spriteNum == 1) {
                        image = right1;
                    } else if (spriteNum == 2) {
                        image = right2;
                    } else if (spriteNum == 3) {
                        image = right3;
                    } else if (spriteNum == 4) {
                        image = right4;
                    } else if (spriteNum == 5) {
                        image = right5;
                    } else if (spriteNum == 6) {
                        image = right6;
                    }
                } else {
                    // default sprite when idle
                    image = right3;
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize * scale, gp.tileSize * scale, null);
    }
}