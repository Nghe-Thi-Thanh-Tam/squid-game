import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable {
    final int scale = 3;
    int FPS = 60;

    private KeyHandler keyH = new KeyHandler();
    private Thread gameThread;
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
    protected Image win = new ImageIcon("res/YouWon.png").getImage();
    protected Image lose = new ImageIcon("res/YouLose.png").getImage();
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
        this.setPreferredSize(new Dimension(1000, 500));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
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

        if ( num == 0) {
            this.step[0][0] = (int) (Math.random() * (2) + 0);
            num++;
            System.out.println(step[0][0]);
        }

        if (step[0][0] == 1 && (player1.x == 48 && player1.y == 88)) {

            mark = 1;
        }

        if (step[0][0] == 0 && (player1.x == 48 && player1.y == 240)) {
            mark = 2;
        }


        if ( num == 1) {
            this.step[0][1] = (int) (Math.random() * 2);
            num++;
            System.out.println(step[0][1]);
        }
        if (step[0][1] == 1 && (player1.x == 236 && player1.y == 88)) {

            mark = 3;
        }

        if (step[0][1] == 0 && (player1.x == 236 && player1.y == 240)) {
            mark = 4;
        }

        if (  num == 2) {
            this.step[0][2] = (int) (Math.random() * 2);
            num++;
            System.out.println(step[0][2]);
        }
        if (step[0][2] == 1 && (player1.x == 420 && player1.y == 88)) {

            mark = 5;
        }

        if (step[0][2] == 0 && (player1.x == 420 && player1.y == 240)) {
            mark = 6;
        }

        if ( num == 3) {
            this.step[0][3] = (int) (Math.random() * 2);
            num++;
            System.out.println(step[0][3]);
        }
        if (step[0][3] == 1 && (player1.x == 604 && player1.y == 88)) {

            mark = 7;
        }

        if (step[0][3] == 0 && (player1.x == 604 && player1.y == 240)) {
            mark = 8;
        }

        if ( num == 4) {
            this.step[0][4] = (int) (Math.random() * 2);
            num++;
            System.out.println(step[0][4]);
        }
        if (step[0][4] == 1 && (player1.x == 796 && player1.y == 88)) {

            mark = 9;
        }

        if (step[0][4] == 0 && (player1.x == 796 && player1.y == 240)) {
            mark = 10;
        }
        if(player1.x==880 && player1.y==160){
            mark=11;
        }

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        switch (mark) {
            case 0:
                g.drawImage(notbreak, 0, 0, 1000, 500, null);

                break;
            case 1:
                g.drawImage(break11, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;

            case 2:
                g.drawImage(break12, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);

                break;
            case 3:
                g.drawImage(break21, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 4:
                g.drawImage(break22, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 5:
                g.drawImage(break31, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 6:
                g.drawImage(break32, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 7:
                g.drawImage(break41, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 8:
                g.drawImage(break42, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 9:
                g.drawImage(break51, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 10:
                g.drawImage(break52, 0, 0, 1000, 500, null);
                g.drawImage(lose, 0, 0, 1000, 500, null);
                break;
            case 11:
                g.drawImage(notbreak, 0, 0, 1000, 500, null);
                g.drawImage(win, 0, 0, 1000, 500, null);
        }

        player1.draw(g2);
        g2.dispose();
    }



}