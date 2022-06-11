package src.Tug_of_War.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerTeam extends JPanel implements MouseListener {
    Image I1 = new ImageIcon("src\\Tug_of_War\\res\\1.png").getImage();
    Image I2 = new ImageIcon("src\\Tug_of_War\\res\\2.png").getImage();

    public int totalMoveTimes = 0;
    private final int moveDistance = 2;
    public boolean isMoved = false;
    public boolean isClicked = false;
    Image image = I1;

    public Image updateImage() {
        return image;
    }

    public int checkMoved() {

        if (isMoved) {
            isMoved = false;
            return getMoveDistance();
        }
        return 0;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (MouseEvent.MOUSE_PRESSED == 501) {
            setImage(I2);
            isMoved = true;
            isClicked = true;
            increaseTotalMoveTimes();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (MouseEvent.MOUSE_RELEASED == 502) {
            setImage(I1);
            isClicked = false;
            System.out.println("Mouse is clicked");
        }
    }




    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public int getTotalMoveTimes() {
        return totalMoveTimes;
    }

    public void increaseTotalMoveTimes() {
        totalMoveTimes++;
    }

    public int getMoveDistance() {
        return moveDistance;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
