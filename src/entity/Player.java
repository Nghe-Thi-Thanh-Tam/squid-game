package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Player extends Entity {
    GamePanel gp;
    public int x0;
    public int y0;
    public int timer=0;
    public int m;
    public KeyHandler keyH;
    public Player (GamePanel gp,KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction ="down";
        alive=true;
    }
    public void getPlayerImage(){
        try{
            up1= ImageIO.read(new File("res/squidChar_Up(2).png"));
            up2= ImageIO.read(new File("res/squidChar_Up(4).png"));
            down1= ImageIO.read(new File("res/squidChar_Toward(2).png"));
            down2= ImageIO.read(new File("res/squidChar_Toward(4).png"));
            left1= ImageIO.read(new File("res/squidChar_Left(1).png"));
            left2= ImageIO.read(new File("res/squidChar_Left(2).png"));
            right1= ImageIO.read(new File("res/squidChar_Right(1).png"));
            right2= ImageIO.read(new File("res/squidChar_Right(2).png"));
            death = ImageIO.read(new File("res/player_dead.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed || keyH.rightPressed || keyH.leftPressed || keyH.downPressed) {
            if (keyH.upPressed == true) {
                if(y<=-50){
                 y-=0;
                    direction = "up";
                }
                else {
                    y -= speed;
                    direction = "up";
                }

            } else if (keyH.downPressed == true) {
                if(y>=gp.screenHeight-100){
                    y-=0;
                    direction = "down";
                }
                else {
                    y += speed;
                    direction = "down";
                }
            } else if (keyH.leftPressed == true) {
                if(x<=-50){
                    x-=0;
                    direction = "left";
                }
                else {
                    x -= speed;
                    direction = "left";
                }
            } else if (keyH.rightPressed == true) {
                if(x>=gp.screenWidth-100){
                x-=0;
                    direction = "right";
            }
                else {
                x += speed;
                direction = "right";
            }
            }
            spriteCounter++;




            }
            if (spriteCounter > 14) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
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



        g2.drawImage(image, x, y, gp.tileSize + 100, gp.tileSize + 100, null);

    }
}
