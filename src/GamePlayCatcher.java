import javax.swing.*;

public class GamePlayCatcher {
    public static void main(String[] args) {
        // write your code here

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 600);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        GamePanelCatcher screen = new GamePanelCatcher();
        window.add(screen);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        screen.startGameThread();
    }
}
