package src;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class UtilityTool {
    
    public BufferedImage scaledImage(BufferedImage original, double width, double height){

        BufferedImage scaledImage = new BufferedImage((int)width, (int)height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, (int)width, (int)height, null);
        g2.dispose();
        return scaledImage;
    }
}
