package src;

import src.GamePanel;
import src.KeyHandler;
import src.UtilityTool;

import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Catcher extends entity.Entity {
    public double x;
    public int y;
    public double charScale;
    static boolean isLooking = false;

    public Catcher(GamePanel gp){
        super(gp);
        setDefaultValues();
        getCatcherImage();
    }

    public void setDefaultValues(){
        x = (gp.width/2 - gp.originalTitleSize * 3.8f); //445
        y = -12; //where to place the doll
        charScale = 2.7f;
        direction = "back";
    }

    public void getCatcherImage(){
        back = setup("back");
        front = setup("front");
    }

    public BufferedImage setup(String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Catcher/" + imageName + ".png")));

            image = uTool.scaledImage(image, charScale * gp.tileSize, charScale * gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public void update() {
        boolean gameEnd=true;
        int GameStatus = 3; //it need to get update from main
        int Green = 3;
        int Yellow = 2;
        int Red = 1;
        if (gameEnd) {
            if (GameStatus == Green) {
                direction = "front";
            }
            else if (GameStatus == Yellow) {
                direction = "back";
                turn();
            }
            else if (GameStatus == Red) {
                direction = "back";
                //play robot sfx!
            }

        }

    }
    public static void run() {
//        lookBack();
//        int random = (int) (Math.random() * (5000) + 17000);
//        wait(random);
//        lookFront();
//        wait(random);

    }

    private void turn() {
    }



    public void drawCatcher(Graphics g)
    {
        BufferedImage image = null;
        //super.paintComponent(g);
        switch (direction) {
            case "back":
                image = back;
                break;
            case "front":
                image = front;
                break;

        }
        g.drawImage(image, (int)x, (int)y , null);
    }

    public static void lookBack(){
        direction = "back";
        isLooking = false;
    }
    public static void lookFront(){
        direction = "front";
        isLooking = true;
    }
    public static void wait(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
