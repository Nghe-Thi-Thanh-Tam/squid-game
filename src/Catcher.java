import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Catcher extends JPanel {
    GamePanelCatcher gp;
    public int x;
    public int y;
    public BufferedImage back, front;
    public String direction;

    public Catcher(GamePanelCatcher gp){
        this.gp = gp;
        setDefaultValues();
        getCatcherImage();
    }

    public void setDefaultValues(){
        x = 500;
        y = 500;
        direction = "up";
    }

    public void getCatcherImage(){
        try {
            back = ImageIO.read(new File("C:/IU Document/Specialized Courses/OOP lab/Catcher/back.png"));
            front = ImageIO.read(new File("C:/IU Document/Specialized Courses/OOP lab/Catcher/front.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(back, 450, 0,150, 150, null);
        g.drawImage(front, 450, 200, 150, 150, null);
    }

    public void turn(){

    }
}
