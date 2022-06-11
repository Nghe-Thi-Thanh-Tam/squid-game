package src.red_light_green_light.src;

import src.red_light_green_light.entity.Player;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    int FPS=60;
    private final int UPS=60;//VERY IMPORTANT

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
    protected Image npc1 = new ImageIcon("src\\red_light_green_light\\res\\NPC\\NPC(1).png").getImage();

    protected Image npc2 = new ImageIcon("src\\red_light_green_light\\res\\NPC\\NPC(2).png").getImage();
    protected Image npc3 = new ImageIcon("src\\red_light_green_light\\res\\NPC\\NPC(3).png").getImage();

    //NEW THREAD AND KEYHANDLER!
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

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
    public Map map = new Map(); //old line
    public Player player1 = new Player(this,keyH);
    public Catcher catcher = new Catcher(this);
    public panelBot panelBot = new panelBot(width, height, map);


    public void update(){
         player1.update();
         catcher.update();
//        panelBot.actionPerformed(null);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
//
//        //map.Map1draw(g2);
//          //this line doesn't work on old technology, but also I hate Unity, so well....
//
        int iSize = startY*2-30;
        int iX = -35;
        int iY = (-1)*iSize/7;
        int offsetY = 35;


        g2.setColor(Color.red);
        g2.fillRect(0, startY-1 + offsetY, width, 3); //brain f***
        g2.fillRect(0, finishY - 1 , width, 3);

        g2.drawImage(npc1, width/9 + iX, iY + offsetY, iSize, iSize, this);
        g2.drawImage(npc1, width - width/9 + iX, iY + offsetY, iSize, iSize, this);

        g2.drawImage(npc2, 2*width/9 + iX, iY + offsetY, iSize, iSize, this);
        g2.drawImage(npc2, width - 2*width/9 + iX, iY + offsetY, iSize, iSize, this);

        g2.drawImage(npc3, 3*width/9 + iX, iY + offsetY, iSize, iSize, this);
        g2.drawImage(npc3, width - 3*width/9 + iX, iY + offsetY, iSize, iSize, this);
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
                frames = 0;
                updates = 0;

            }
        }
    }
}
