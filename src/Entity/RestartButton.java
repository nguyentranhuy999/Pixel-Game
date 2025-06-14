package Entity;

import Main.GamePanel;
import Main.MouseHandle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RestartButton extends Entity {
    GamePanel gamePanel;
    BufferedImage image;
    MouseHandle mouseHandle;
    public boolean restart = false;

    // Constructor
    public RestartButton(GamePanel gamePanel,MouseHandle mouseHandle) {
        this.gamePanel = gamePanel;
        this.mouseHandle = mouseHandle;
        setDefautValues();
        getPauseButtonImage();
        image = restart1;
    }

    // Set possition
    public void setDefautValues() {
        x = 2 * gamePanel.tileSize;
        y = 0;
    }

    // Get image
    public void getPauseButtonImage() {
        try {
            restart1 = ImageIO.read((getClass().getResourceAsStream("/tiles/restart_button1.png")));
            restart2 = ImageIO.read((getClass().getResourceAsStream("/tiles/restart_button2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void update() {
        if (mouseHandle.enter) {
            if (image == restart1) {
                image = restart2;
            }
            mouseHandle.enter = false;
        }

        if (mouseHandle.exit) {
            if (image == restart2) {
                image = restart1;
            }
            mouseHandle.exit = false;
        }

        if (mouseHandle.click) {
            restart = true;
            mouseHandle.click = false;
        }
    }

    // Draw
    public void draw(Graphics2D g2D) {
        g2D.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
