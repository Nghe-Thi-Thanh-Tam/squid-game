package src.red_light_green_light.src;

import javax.swing.*;


public class Gameplay {

    public static void main(String[] args) {
	// write your code here
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        GamePanel screen = new GamePanel();
        window.add(screen);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        screen.startGameThread();
    }
}
