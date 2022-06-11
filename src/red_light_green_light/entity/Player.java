package src.red_light_green_light.entity;

import src.red_light_green_light.src.GamePanel;
import src.red_light_green_light.src.KeyHandler;
import src.red_light_green_light.src.UtilityTool;

import java.awt.*;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class Player extends Entity {
    public double x;
    public double y;
    public int timer = 0;
    public int m;
    public static boolean playerMove = false;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = (gp.width/2 - gp.originalTitleSize * 5f );
        y = (gp.finishY - gp.originalTitleSize * 4f) ;
        speed = 1;
        direction = "down";
        alive = true;
    }
    public void getPlayerImage() {
        up1 = setup("Up(2)");
        up2 = setup("Up(4)");
        down1 = setup("Toward(2)");
        down2 = setup("Toward(4)");
        left1 = setup("Left(1)");
        left2 = setup("Left(2)");
        right1 = setup("Right(1)");
        right2 = setup("Right(2)");
        dead = setup("dead");
    }

    public BufferedImage setup(String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File("src/red_light_green_light/res/Player/squidChar_"+imageName+".png"));
            double charScale = 3.50f;
            image = uTool.scaledImage(image, charScale * gp.tileSize, charScale * gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public void update() {
        if (keyH.upPressed ||
                keyH.rightPressed || keyH.leftPressed || keyH.downPressed) { // = true;
            if
            (keyH.upPressed) {
                if (y <= -50) {
                    y -= 0;
                    direction = "up";
                } else {
                    y -= speed;
                    direction = "up";
                }
                //playerMove = false;

            } else if (keyH.downPressed) {
                if (y >= gp.screenHeight - 100) {
                    y -= 0;
                    direction = "down";
                } else {
                    y += speed;
                    direction = "down";
                }
            } else if
            (keyH.leftPressed) {//playerMove = true;
                if (x <= -50) {
                    x -= 0;
                    direction = "left";
                } else {
                    x -= speed;
                    direction = "left";
                }
            } else if (keyH.rightPressed) {
                if (x >= gp.screenWidth - 100) {
                    x -= 0;
                    direction = "right";
                } else {
                    x += speed;
                    direction = "right";
                }


            }
            spriteCounter++;
        } //else playerMove = false;
//        System.out.println("player moved?" + playerMove);


        if (spriteCounter > 14) {


            if (spriteNum == 1) {
                spriteNum = 2;
            } else if
            (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics g) {
        //g.setColor(Color.white);
        //g.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if
                (spriteNum == 2) {
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
                if (spriteNum ==
                        2) {
                    image = right2;
                }
                break;
        }
        if (alive == false) {
            g.drawImage(dead, (int)x, (int)y , null);} else
        g.drawImage(image, (int)x, (int)y , null);


    }
}
