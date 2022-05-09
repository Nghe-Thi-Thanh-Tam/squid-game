import javax.swing.*;
import java.awt.*;

public class Map extends JPanel{
    private int width;
    private int height;
    protected int startY;
    protected int finishY;
    protected Image npc1 = new ImageIcon("res\\NPC\\NPC(1).png").getImage();

    protected Image npc2 = new ImageIcon("res\\NPC\\NPC(2).png").getImage();
    protected Image npc3 = new ImageIcon("res\\NPC\\NPC(3).png").getImage();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        width = getWidth();
        height = getHeight();

        startY = height/9;
        finishY = height - startY;

        int iSize = getStartY()*2-30;
        int iX = -35;
        int iY = (-1)*iSize/7;


        g.setColor(Color.red);
        g.fillRect(0, startY-1, width, 3);
        g.fillRect(0, finishY-1, width, 3);

        g.drawImage(npc1, width/9 + iX, iY, iSize, iSize, this);
        g.drawImage(npc1, width - width/9 + iX, iY, iSize, iSize, this);

        g.drawImage(npc2, 2*width/9 + iX, iY, iSize, iSize, this);
        g.drawImage(npc2, width - 2*width/9 + iX, iY, iSize, iSize, this);

        g.drawImage(npc3, 3*width/9 + iX, iY, iSize, iSize, this);
        g.drawImage(npc3, width - 3*width/9 + iX, iY, iSize, iSize, this);
    }


    public int getStartY() {
        return startY;
    }

    public int getFinishY() {
        return finishY;
    }

}
