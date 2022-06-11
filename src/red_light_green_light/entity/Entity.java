package src.red_light_green_light.entity;

import src.red_light_green_light.src.GamePanel;

import java.awt.image.BufferedImage;

public class Entity {

    public int x,y;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2, dead,front,back;
    public static String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    public static boolean alive =true;
    public GamePanel gp;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
}
