import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable {
    final int originalTitleSize = 16;
    final int scale = 3;
    int FPS = 60;

    public final int tileSize = originalTitleSize * scale;
    final int maxScreenCol = 100;
    final int maxScreenRow = 600;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    int[][] step = new int[2][5];
    int mark = 0;
    Player player1 = new Player(this, keyH);


    protected Image notbreak = new ImageIcon("res/bridge.png").getImage();
    protected Image break11 = new ImageIcon("res/broken_(0,0).png").getImage();
    protected Image break12 = new ImageIcon("res/broken_(1,0).png").getImage();
    protected Image break21 = new ImageIcon("res/broken_(0,1).png").getImage();
    protected Image break22 = new ImageIcon("res/broken_(1,1).png").getImage();
    protected Image break31 = new ImageIcon("res/broken_(0,2).png").getImage();
    protected Image break32 = new ImageIcon("res/broken_(1,2).png").getImage();
    protected Image break41 = new ImageIcon("res/broken_(0,3).png").getImage();
    protected Image break42 = new ImageIcon("res/broken_(1,3).png").getImage();
    protected Image break51 = new ImageIcon("res/broken_(0,4).png").getImage();
    protected Image break52 = new ImageIcon("res/broken_(1,4).png").getImage();

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    int count=0;
     int num=0;
    public void update() {
        player1.update();


        count++;

        if (((player1.x == 150 && player1.y == 200) || (player1.x == 150 && player1.y == 460)) && num == 0) {
            this.step[0][0] = (int) (Math.random() * (2) + 0);
            num++;
        }

        if (step[0][0] == 1 && (player1.x == 150 && player1.y == 200)) {

            mark = 1;
        }

        if (step[0][0] == 0 && (player1.x == 150 && player1.y == 460)) {
            mark = 2;
        }


        if (((player1.x == 350 && player1.y == 200) || (player1.x == 350 && player1.y == 460)) && num == 1) {
            this.step[0][1] = (int) (Math.random() * 2);
            num++;
        }
        if (step[0][1] == 1 && (player1.x == 350 && player1.y == 200)) {

            mark = 3;
        }

        if (step[0][1] == 0 && (player1.x == 350 && player1.y == 460)) {
            mark = 4;
        }

        if (((player1.x == 650 && player1.y == 200) || (player1.x == 650 && player1.y == 460)) && num == 2) {
            this.step[0][2] = (int) (Math.random() * 2);
            num++;
        }
        if (step[0][2] == 1 && (player1.x == 650 && player1.y == 200)) {

            mark = 5;
        }

        if (step[0][2] == 0 && (player1.x == 650 && player1.y == 460)) {
            mark = 6;
        }

        if (((player1.x == 1050 && player1.y == 200) || (player1.x == 1050 && player1.y == 460)) && num == 3) {
            this.step[0][3] = (int) (Math.random() * 2);
            num++;
        }
        if (step[0][3] == 1 && (player1.x == 1050 && player1.y == 200)) {

            mark = 7;
        }

        if (step[0][2] == 0 && (player1.x == 1050 && player1.y == 460)) {
            mark = 8;
        }

        if (((player1.x == 1350 && player1.y == 200) || (player1.x == 1350 && player1.y == 460)) && num == 4) {
            this.step[0][4] = (int) (Math.random() * 2);
            num++;
        }
        if (step[0][4] == 1 && (player1.x == 1350 && player1.y == 200)) {

            mark = 9;
        }

        if (step[0][4] == 0 && (player1.x == 1350 && player1.y == 460)) {
            mark = 10;
        }

    }









    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        switch (mark){
            case 0:
                g.drawImage(notbreak,0,0,1600,900,null);

                break;
            case 1 :
                g.drawImage(break11,0,0,1600,900,null);
//                gameThread.stop();
                break;

            case 2:
                g.drawImage(break12,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 3:
                g.drawImage(break21,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 4:
                g.drawImage(break22,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 5:
                g.drawImage(break31,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 6:
                g.drawImage(break32,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 7:
                g.drawImage(break41,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 8:
                g.drawImage(break42,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 9:
                g.drawImage(break51,0,0,1600,900,null);
//                gameThread.stop();
                break;
            case 10:
                g.drawImage(break52,0,0,1600,900,null);
//                gameThread.stop();
                break;
        }

        player1.draw(g2);
        g2.dispose();
    }



}