package src;

import entity.Player;

public class gameLogic{
    KeyHandler keyH = new KeyHandler();
//    public Player player1 = new Player(new GamePanel(), keyH);

    public gameLogic() {
        System.out.println("Game starts in 3!");
        wait(1000);
        System.out.println("Game starts in 2!");
        wait(1000);
        System.out.println("Game starts in 1!");
        wait(1000);
        System.out.println("Game started!");
        gameStart();


    }
    private void gameStart() {
        GamePanel.GameStat = "started";
        Catcher.run();

    }

    public void check() {
        if (GamePanel.isLooking && GamePanel.playerMove) {System.out.println("Game Over!");//endgame
            Player.alive = false;
            GamePanel.GameStat = "end";
        }
    }

        public static void wait(int ms)
        {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
