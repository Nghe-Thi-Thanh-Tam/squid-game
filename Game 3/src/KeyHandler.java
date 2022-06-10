
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public int numberOfClick=0;
    public int upPress=0,downPress;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code =e.getKeyCode();
        if(code == KeyEvent.VK_W){

        }
        if(code == KeyEvent.VK_S){

        }
        if(code == KeyEvent.VK_A){

        }
        if(code == KeyEvent.VK_D){

        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            numberOfClick++;
            upPress = 1;
        }
        if (code == KeyEvent.VK_S) {
            numberOfClick++;
            downPress = 1;
        }
        if (code == KeyEvent.VK_A) {

        }
        if (code == KeyEvent.VK_D) {

        }
    }
}
