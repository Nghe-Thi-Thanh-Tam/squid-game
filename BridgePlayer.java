import javax.imageio.ImageIO;
import javax.swing.*;


// chéo lên, xuống + qua phải


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BridgePlayer extends JPanel {

    GamePanel gp;
    public int x;
    public int y;
    public int dx=188, dy=152;
    public BufferedImage right1,right2;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;

    public KeyHandler keyH;

    public BridgePlayer(GamePanel gp, KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;
        setDefaultValues();
        getPlayerImage();
    }


    public void setDefaultValues(){
        x=-40;
        y=88;
        direction ="right";
    }


    public void getPlayerImage(){
        try{

            //left1= ImageIO.read(new File("C:/Users/ACER/IdeaProjects/Bridge/res/Player/Left/squidChar_Left(1).png"));
            //left2= ImageIO.read(new File("C:/Users/ACER/IdeaProjects/Bridge/res/Player/Left/squidChar_Left(2).png"));
            right1= ImageIO.read(new File("C:/Users/ACER/IdeaProjects/Bridge/res/Player/Right/squidChar_Right(1).png"));
            right2= ImageIO.read(new File("C:/Users/ACER/IdeaProjects/Bridge/res/Player/Right/squidChar_Right(2).png"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if( keyH.upPressed || keyH.downPressed ) {


            if (keyH.upPressed == true) {
                if(x <= gp.screenWidth && y == 88){    // 1st row
                    x += dx;
                    //direction = "left";
                }
                else if (x <= gp.screenWidth && y == 240){    // 2nd row
                    x += dx;
                    y -= dy;
                    //direction = "left";
                }

            } else if (keyH.downPressed == true) {
                if(x <= gp.screenWidth && y == 88){    // 1st row
                    x += dx;
                    y += dy;
                    //direction = "right";
                }
                else if (x <= gp.screenWidth && y == 240) {    // 2nd row
                    x += dx;
                    //direction = "right";
                }

            }
            spriteCounter++;

        }
        if (spriteCounter > 14) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
                keyH.upPressed = false;
                keyH.downPressed = false;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics g) {
        //BufferedImage image = null;

        g.drawImage(right1, x, y, 160, 160, null);

        System.out.println(x);
        System.out.println(y);

    }
}
