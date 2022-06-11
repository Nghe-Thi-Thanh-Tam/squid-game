package src.Glass_Bridge.src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;


public class Player extends Entity  {
    GamePanel gp;
   private int mark=0;
    public KeyHandler keyH;
    int count=0;
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {
        x = -40 ;
        y = 160;

        direction = "right";

    }


    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Up(2).png"));
            up2 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Up(4).png"));
            down1 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Toward(2).png"));
            down2 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Toward(4).png"));
            left1 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Left(1).png"));
            left2 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Left(2).png"));
            right1 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Right(1).png"));
            right2 = ImageIO.read(new File("src/Glass_Bridge/res/squidChar_Right(2).png"));
            death = ImageIO.read(new File("src/Glass_Bridge/res/player_dead.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {

        if(keyH.numberOfClick==1 && keyH.upPress==1){
            x=48;
            y=88;
            keyH.upPress=0;
        }
        if(keyH.numberOfClick==1 && keyH.downPress==1){
            x=48;
            y=240;
            keyH.downPress=0;
        }
        if(keyH.numberOfClick==2 && keyH.upPress==1){
            x=236;
            y=88;
            keyH.upPress=0;
        }
        if(keyH.numberOfClick==2 && keyH.downPress==1){
            x=236;
            y=240;
            keyH.downPress=0;
        }
        if(keyH.numberOfClick==3 && keyH.upPress==1){
            x=420;
            y=88;
            keyH.upPress=0;
        }
        if(keyH.numberOfClick==3 && keyH.downPress==1){
            x=420;
            y=240;
            keyH.downPress=0;
        }
        if(keyH.numberOfClick==4 && keyH.upPress==1 ){
            x=604;
            y=88;
            keyH.upPress=0;
        }
        if(keyH.numberOfClick==4 && keyH.downPress==1){
            x=604;
            y=240;
            keyH.downPress=0;
        }
        if(keyH.numberOfClick==5 && keyH.upPress==1){
            x=796;
            y=88;
            keyH.upPress=0;
        }
        if(keyH.numberOfClick==5 && keyH.downPress==1){
            x=796;
            y=240;
            keyH.downPress=0;
        }

        if(keyH.numberOfClick==6 && (keyH.downPress==1 ||keyH.upPress==1)){
            x=880;
            y=160;


        }

    }

    public void draw(Graphics g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        if(gp.mark==1 || gp.mark==2 || gp.mark==3 || gp.mark==4 || gp.mark==5 || gp.mark==6 || gp.mark==7 || gp.mark==8 || gp.mark==9 || gp.mark==10){
            image=null;
        }




        g2.drawImage(image, x, y, 160,  160, null);

    }
}
