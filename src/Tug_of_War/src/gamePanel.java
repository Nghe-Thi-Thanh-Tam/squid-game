import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class gamePanel extends JPanel implements Runnable {
    OpponentTeam opponent = new OpponentTeam();
    PlayerTeam player = new PlayerTeam();

    Image image = new ImageIcon("res\\1.png").getImage();
    Image win = new ImageIcon("res\\win.png").getImage();
    Image lose = new ImageIcon("res\\lose.png").getImage();

    Image background = new ImageIcon("res\\background.png").getImage();
    Image num0 = new ImageIcon("res\\countDown\\num_0.png").getImage();
    Image num1 = new ImageIcon("res\\countDown\\num_1.png").getImage();
    Image num2 = new ImageIcon("res\\countDown\\num_2.png").getImage();
    Image num3 = new ImageIcon("res\\countDown\\num_3.png").getImage();


    Sound sound = new Sound();
    ArrayList<Image> countDownNumber = new ArrayList<>();
    int maximumDifference = 45;
    int totalMoveTimesDifference = 0;
    private int x =  -33; //-(int) (157 * 0.5 / 2) + 6;
    final int y = -116; //-(int) (461 * 0.5 / 2) + 1;
    Thread gameThread;
    int FPS = 70;

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
                System.out.println("You lose");
                repaint();
                break;
            } else if (totalMoveTimesDifference == maximumDifference) {
                image = win;
                System.out.println("You win");
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
            opponent.updateConditionMove();
            x -= opponent.checkConditionMove();
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
            g.setColor(Color.RED);
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

