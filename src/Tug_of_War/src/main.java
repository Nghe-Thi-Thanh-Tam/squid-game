import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        gamePanel game = new gamePanel();
        window.add(game);
        window.setSize(1000, 500);
        window.setFocusable(true);
        window.setVisible(true);
        game.startGameThread();
    }
}
