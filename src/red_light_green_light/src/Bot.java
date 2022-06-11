package src.red_light_green_light.src;
import src.red_light_green_light.src.UtilityTool;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Bot extends Rectangle {
    private Map map = new Map();
    public GamePanel gp;
    public Image up1,up2,up,left1,left2,right1,right2,dead;
    protected int x;
    protected int y;
    Image iBot;
    private int width;
    private int height;
    protected int indexMove;
    protected int border;
    private final int speed=4;
    int index;
    boolean isWin = false;
    boolean isDead = false;
    public Bot(int x, int y, int width, int height, int indexMove) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        border = (this.width+this.height)/10;

        this.indexMove = indexMove;
        setIndexMove(1);
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public void loadImage() {
        up = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Up(1).png").getImage();
        up1 = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Up(2).png").getImage();
        up2 = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Up(3).png").getImage();
        right1 = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Right(1).png").getImage();
        right2 = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Right(2).png").getImage();
        left1 = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Left(1).png").getImage();
        left2 = new ImageIcon("src\\red_light_green_light\\res\\Bot\\Left(2).png").getImage();
        dead = new ImageIcon("src\\red_light_green_light\\res\\Bot\\dead.png").getImage();
    }
    public void draw(Graphics g, ImageObserver o) {
        spriteIndex();
        g.drawImage(iBot, this.x, this.y, border, border, o);
    }

    public void moveLeft() {
        if(x>-40) {
            x -= speed;
            switch (indexMove) {
                case 1 -> iBot = left1;
                case 2 -> iBot = left2;
            }
        }
    }
    public void moveRight() {
        if (x < width+61) {
            x += speed;
            switch (indexMove) {
                case 1 -> iBot = right1;
                case 2 -> iBot = right2;
            }
        }
    }
    public void moveUp() {
        if (y>=-50) {
            y -= speed;
            switch (indexMove) {
                case 1 -> iBot = up1;
                case 2 -> iBot = up2;
            }
        }

    }
    public void still(){
        iBot = up;
    }

    public void randomMove() {
        if(isWin!=true) {
            index = (int) (Math.random() * (7 - 1 + 1) + 1);
            switch (index) {
                case 1 -> moveLeft();
                case 2 -> moveRight();
                case 3 -> still();
                default -> moveUp();
            }
        }
    }

    public void spriteIndex() {
        switch (getIndexMove()) {
            case 1 -> indexMove = 2;
            case 2 -> indexMove = 1;
        }
    }

    public int getIndexMove() {
        return indexMove;
    }

    public void setIndexMove(int indexMove) {
        this.indexMove = indexMove;
    }

    public void checkDead(boolean b) {
        if (b) {
            iBot = dead;
            isDead = true;
        }
    }

    public void checkWin() {
        if (y<height/9 - 65 - 35 - 5) {
            iBot = up;
            isWin = true;
        }
    }

}
