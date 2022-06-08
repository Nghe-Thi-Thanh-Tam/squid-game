import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class OpponentTeam {
    Image I1 = new ImageIcon("res\\1.png").getImage();

    //only in case player is not clicking
    Image I3 = new ImageIcon("res\\special.png").getImage();
    Image image = I1;
    public int totalMoveTimes = 0;
    private final double speed = 0.000005;
    private double conditionMove = 0;


    public void updateConditionMove() {
        conditionMove += getSpeed();
    }

    public Image updateImage() {
        return image;
    }

    public int checkConditionMove() {
        if ((int)getConditionMove() == 1) {
            setConditionMove(0);
            increaseTotalMoveTimes();

            //update image
            if (image == I1)
                image = I3;
            else image = I1;

            return 2;
        }
        else {
            return 0;
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getTotalMoveTimes() {
        return totalMoveTimes;
    }

    public void increaseTotalMoveTimes() {
        totalMoveTimes++;
    }

    public double getSpeed() {
        return speed;
    }

    public double getConditionMove() {
        return conditionMove;
    }

    public void setConditionMove(double conditionMove) {
        this.conditionMove = conditionMove;
    }
}
