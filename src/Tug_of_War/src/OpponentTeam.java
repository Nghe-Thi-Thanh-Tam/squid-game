package src.Tug_of_War.src;

import javax.swing.*;
import java.awt.*;

public class OpponentTeam {
    Image I1 = new ImageIcon("src\\Tug_of_War\\res\\1.png").getImage();

    //only in case player is not clicking
    Image I2 = new ImageIcon("src\\Tug_of_War\\res\\special.png").getImage();
    Image image = I1;
    public int totalMoveTimes = 0;
    private final double speed = 0.000005;
    private double conditionToMove = 0;


    public void updateConditionToMove() {
        conditionToMove += getSpeed();
    }

    public Image updateImage() {
        return getImage();
    }

    public int checkConditionToMove() {
        if ((int) getConditionToMove() == 1) {
            setConditionToMove(0);
            increaseTotalMoveTimes();

            //update image
            if (getImage() == I1)
                setImage(I2);
            else setImage(I1);

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

    public double getConditionToMove() {
        return conditionToMove;
    }

    public void setConditionToMove(double conditionToMove) {
        this.conditionToMove = conditionToMove;
    }
}
