package src;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements Runnable {
    static boolean playerMove = Player.playerMove;
    public static boolean isLooking = Catcher.isLooking;
    int FPS=60;
    private final int UPS=60;//VERY IMPORTANT
    public static String GameStat = "start";

    //SCREEN SETTING ONLY
    public final int originalTitleSize=16;
    final int scale=4;
    public final int tileSize=originalTitleSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    public final int screenWidth=tileSize*maxScreenCol; //=1024
    public final int screenHeight=tileSize*maxScreenRow; //=768

    //MAP SETTING:)

    public final int width = screenWidth; //lazy code:)
    public final int height = screenHeight;

    public final int startY = height/9;
    public final int finishY = height - startY ;
    protected Image npc1 = new ImageIcon("res\\NPC\\NPC(1).png").getImage();

    protected Image npc2 = new ImageIcon("res\\NPC\\NPC(2).png").getImage();
    protected Image npc3 = new ImageIcon("res\\NPC\\NPC(3).png").getImage();

    //NEW THREAD AND KEYHANDLER!
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    public Map map = new Map(); //old line
    public Player player1 = new Player(this,keyH);
    public Catcher catcher = new Catcher(this);
    public panelBot panelBot = new panelBot(width, height, map);
    public gameLogic gameLogic = new gameLogic();


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();

    }
    public void stopGameThread(){
        gameThread.stop();
    }


    public void update(){
//        gameLogic.check();
//        wait(5000);
        player1.update();
        catcher.update();
//        gameLogic.check();
//        panelBot.actionPerformed(null);
    }
    public void paintMap(Graphics g){
        //too much referencing value, so I rather bring it here to save time:)
        int iSize = startY*2-30;
        int iX = -35;
        int iY = (-1)*iSize/7;
        int offsetY = 35;


        g.setColor(Color.red);
        g.fillRect(0, startY-1 + offsetY, width, 3); //brain f***
        g.fillRect(0, finishY - 1 , width, 3);

        g.drawImage(npc1, width/9 + iX, iY + offsetY, iSize, iSize, this);
        g.drawImage(npc1, width - width/9 + iX, iY + offsetY, iSize, iSize, this);

        g.drawImage(npc2, 2*width/9 + iX, iY + offsetY, iSize, iSize, this);
        g.drawImage(npc2, width - 2*width/9 + iX, iY + offsetY, iSize, iSize, this);

        g.drawImage(npc3, 3*width/9 + iX, iY + offsetY, iSize, iSize, this);
        g.drawImage(npc3, width - 3*width/9 + iX, iY + offsetY, iSize, iSize, this);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
//
//        //map.Map1draw(g2);
//          //this one line is buggy, so no:)
//
        paintMap(g2);
        catcher.drawCatcher(g2);
        player1.draw(g2);
        panelBot.paintBot(g2);
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;
        while (true) {
            Catcher.run();
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
//                if (isLooking && playerMove) {System.out.println("Game Over!");}
//                else System.out.println("Game Running!");
                frames = 0;
                updates = 0;

            }
        }
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
