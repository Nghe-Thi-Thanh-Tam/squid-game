//
//
//import main_old.Catcher;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class GamePanelCatcher extends JPanel implements Runnable{
//    final int originalTitleSize=16;
//    final int scale=3;
//    int FPS=60;
//    public final int tileSize=originalTitleSize*scale;
//    final int maxScreenCol=16;
//    final int maxScreenRow=12;
//    public final int screenWidth=tileSize*maxScreenCol;
//    public final int screenHeight=tileSize*maxScreenRow;
//    Thread gameThread;
//
//    public GamePanelCatcher(){
//        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
//        this.setBackground(Color.white);
//        this.setDoubleBuffered(true);
//        this.setFocusable(true);
//
//    }
//    public void startGameThread(){
//        gameThread=new Thread(this);
//        gameThread.start();
//    }
//    /*public void stopGameThread(){
//        gameThread.stop();
//    }*/
//
//    //public Catcher catcher1 = new Catcher(this);
//    @Override
//    public void run() {
//        double drawInterval=1000000000/FPS;
//        double delta=0;
//        long lastTime =System.nanoTime();
//        long currentTime;
//        while (gameThread!= null){
//            currentTime= System.nanoTime();
//            delta+=(currentTime-lastTime)/drawInterval;
//            lastTime = currentTime;
//            if(delta>=1){
//                repaint();
//                delta--;
//            }
//
//        }
//    }
//
//    public void paintComponent(Graphics g){
//        //super.paintComponent(g);
//        //Graphics2D g2 =(Graphics2D) g;
//
//
//        catcher1.paintComponent(g);
//    }
//}
