package src.Tug_of_War.src;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class gamePanel extends JPanel implements Runnable {
    OpponentTeam opponent = new OpponentTeam();
    PlayerTeam player = new PlayerTeam();

    Image image = new ImageIcon("src\\Tug_of_War\\res\\1.png").getImage();
    Image win = new ImageIcon("src\\Tug_of_War\\res\\win.png").getImage();
    Image lose = new ImageIcon("src\\Tug_of_War\\res\\lose.png").getImage();

    Image background = new ImageIcon("src\\Tug_of_War\\res\\background.png").getImage();
    Image num0 = new ImageIcon("src\\Tug_of_War\\res\\countDown\\num_0.png").getImage();
    Image num1 = new ImageIcon("src\\Tug_of_War\\res\\countDown\\num_1.png").getImage();
    Image num2 = new ImageIcon("src\\Tug_of_War\\res\\countDown\\num_2.png").getImage();
    Image num3 = new ImageIcon("src\\Tug_of_War\\res\\countDown\\num_3.png").getImage();

    Image YouLose = new ImageIcon("src\\Tug_of_War\\res\\YouLose.png").getImage().getScaledInstance((int)(700*1.5-30), (int)(461*1.5-30), Image.SCALE_DEFAULT);
    Image YouWon = new ImageIcon("src\\Tug_of_War\\res\\YouWon.png").getImage().getScaledInstance((int)(700*1.5), (int)(461*1.5), Image.SCALE_DEFAULT);;
    Image endGameImage = null;
    Sound sound = new Sound();
    ArrayList<Image> countDownNumber = new ArrayList<>();
    private int maximumDifference = 45;
    private int totalMoveTimesDifference = 0;
    private int x =  -33; //-(int) (157 * 0.5 / 2) + 6;
    private final int y =   -116; //-(int) (461 * 0.5 / 2) + 1;
    Thread gameThread;
    private int FPS = 70;

    public gamePanel() {
        this.setFocusable(true);
        this.addMouseListener(player);

        countDownNumber.add(num0);
        countDownNumber.add(num1);
        countDownNumber.add(num2);
        countDownNumber.add(num3);


    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        int timeWait = 3;

        while (gameThread != null) {

            //counting down
            if(timeWait > 0){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                timeWait--;

            }


            //main updates
            if (totalMoveTimesDifference == -maximumDifference) {
                image = lose;
                repaint();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                endGameImage = YouLose;
                repaint();
                break;
            } else if (totalMoveTimesDifference == maximumDifference) {
                image = win;
                repaint();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                endGameImage = YouWon;
                repaint();
                break;
            } else {

                update();
                repaint();
            }


            //setting FPS
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime<0) remainingTime=0;

                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void update() {

        if(x <= 60 && x >= -143) {

            //update image;
            if (player.isClicked) {
                image = player.updateImage();
            }
            else image = opponent.updateImage();

            //update position
            opponent.updateConditionToMove();
            x -= opponent.checkConditionToMove();
            x += player.checkMoved();



            totalMoveTimesDifference = player.getTotalMoveTimes() - opponent.getTotalMoveTimes();
        }
    }

    public void paintComponent(Graphics g) {

        int width = getWidth(); //984 -> 492
        int height = getHeight(); //461 -> 230

        super.paintComponent(g);

        if (countDownNumber.size() == 0) {

            g.drawImage(background, 0, 0, width, height, this);
            g.drawImage(image, x, y,(int)(700*1.5), (int)(461*1.5), this);
            if (endGameImage != null) {
                g.drawImage(endGameImage, -15, y,this);
            }
        }

        else {

            this.setBackground(Color.black);
            g.drawImage(countDownNumber.get(countDownNumber.size()-1), 0, 0, width-100, height, this);
            countDownNumber.remove(countDownNumber.size()-1);
        }

        g.dispose();
    }

    public void playSound(int i) {
        sound.setFile(i);
        sound.play();
    }

    public void stopSound() {
        sound.stop();
    }
}

