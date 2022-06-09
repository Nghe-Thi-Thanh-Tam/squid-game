import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class gamePanel extends JPanel implements MouseListener, Runnable {

    Image I1 = new ImageIcon("res\\1.png").getImage();//.getScaledInstance((int)(700*1.5), (int)(461*1.5), Image.SCALE_DEFAULT);
    Image I2 = new ImageIcon("res\\2.png").getImage();//.getScaledInstance((int)(700*1.5), (int)(461*1.5), Image.SCALE_DEFAULT);

    //only in case player is not clicking
    Image I3 = new ImageIcon("res\\special.png").getImage();//.getScaledInstance((int)(700*1.5), (int)(461*1.5), Image.SCALE_DEFAULT);
    Image win = new ImageIcon("res\\win.png").getImage();//.getScaledInstance((int)(700*1.5), (int)(461*1.5), Image.SCALE_DEFAULT);
    Image lose = new ImageIcon("res\\lose.png").getImage();//.getScaledInstance((int)(700*1.5), (int)(461*1.5), Image.SCALE_DEFAULT);

    Image image= I1;
    Image background = new ImageIcon("res\\background.png").getImage();
    Image num0 = new ImageIcon("res\\num_0.png").getImage();
    Image num1 = new ImageIcon("res\\num_1.png").getImage();
    Image num2 = new ImageIcon("res\\num_2.png").getImage();
    Image num3 = new ImageIcon("res\\num_3.png").getImage();

    Image WinScreen = new ImageIcon("res\\YouWon.png").getImage();


    ArrayList<Image> countDownNumber = new ArrayList<>();
    int numberOfCLick=0;
    int maximumDifferenceOfClicks = 45;
    int totalClickDifference = 0;
    int x =  -33; //-(int) (157 * 0.5 / 2) + 6;
    final int y = -116; //-(int) (461 * 0.5 / 2) + 1;
    Thread gameThread;
    int FPS = 70;
    double opponentMove=0;

    public gamePanel() {
        this.addMouseListener(this);
        this.setFocusable(true);

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

        //counting down
        while (gameThread != null) {

            if(timeWait >= 0){
                System.out.println(timeWait);
                timeWait--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            //update characters' status
            update();

            //repaint after remainingTime(millisecond)
            repaint();

            //setting FPS
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime<0) remainingTime=0;

                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(totalClickDifference == -maximumDifferenceOfClicks ) {
                image = lose;
                System.out.println("You lost");
                repaint();
                break;
            } else if (totalClickDifference == maximumDifferenceOfClicks) {
                image = win;
                System.out.println("You won");
                repaint();
                break;
            }
        }

    }

    public void update() {
        double plusAmount = 0.000005;
        if (opponentMove < 1){
            opponentMove += plusAmount;
        } else if (opponentMove >= 1){

            if(x <= 60 && x >= -143) {

                //update image
                if (image == I1) {
                    image = I3;
                }
                else image = I1;

                //update position
                x -= 2;

                totalClickDifference--;
                opponentMove = 0;
            }
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
//            g.drawLine(width / 2, 0, width / 2, height);
            if (image == win) {
                g.drawImage(WinScreen, -30, y,(int)(700*1.5), (int)(461*1.5), this);
            }
        }

        else {

            this.setBackground(Color.black);
            g.drawImage(countDownNumber.get(countDownNumber.size()-1), 0, 0, width-100, height, this);
            countDownNumber.remove(countDownNumber.size()-1);
        }

        g.dispose();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (MouseEvent.MOUSE_PRESSED == 501) {
            image = I2;
            numberOfCLick++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (MouseEvent.MOUSE_RELEASED == 502) {
            image = I1;
            if(x <= 98 && x >= -105) {
                x += 2;
                totalClickDifference++;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mouseExited(MouseEvent e) {

    }



    @Override
    public void mouseEntered(MouseEvent e) {

    }






}
