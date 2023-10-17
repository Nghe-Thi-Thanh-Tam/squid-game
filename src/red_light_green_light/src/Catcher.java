package src.red_light_green_light.src;

import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Catcher extends src.red_light_green_light.entity.Entity {
    public double x;
    public int y;
    public double charScale;

    public Catcher(GamePanel gp){
        super(gp);
        setDefaultValues();
        getCatcherImage();
    }

    public void setDefaultValues(){
        x = (gp.width/2 - gp.originalTitleSize * 3.8f); //445
        y = -12; //where to place the doll
        charScale = 2.7f;
        direction = "facingFront";
    }

    public void displayText(String text) {
    this.text = text;
}

    public void setIsFront(boolean isFront) {
    this.isFront = isFront;
}

    public void getCatcherImage(){
        back = setup("back");
        front = setup("front");
    }

    public BufferedImage setup(String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File("src/red_light_green_light/res/Catcher/" + imageName + ".png"));

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
   public void drawCatcher(Graphics g) {
    BufferedImage image = null;
    // super.paintComponent(g);

    if (isFront) {
        image = front;
    } else {
        image = back;
    }

    g.drawImage(image, (int) x, (int) y, null);

    if (!text.isEmpty()) {
        // Adjust the coordinates for text display
        int textX = (int) x; // Adjust as needed
        int textY = (int) y + image.getHeight() + 10; // Adjust as needed
        g.drawString(text, textX, textY);
    }
}


    public void turn(){ // implement sound here!!!

    }
}
