package src.red_light_green_light.src;

import java.awt.*;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class GameLogic {
    private GamePanel gamePanel;
    private volatile boolean gameRunning = false;
    private volatile boolean greenLight = false;
    private volatile boolean gameOver = false;
    private volatile int countdown = 3;
    private Catcher catcher;
    private final Semaphore gameLogicSemaphore = new Semaphore(1);
    private Random random = new Random();
    private Point[] characterPositions;
    private String text = "";
    private boolean isFront = false;

    public GameLogic(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        catcher = gamePanel.catcher;
        characterPositions = new Point[gamePanel.panelBot.numberOfBot + 1]; // Include the player

        for (int i = 0; i < characterPositions.length; i++) {
            characterPositions[i] = new Point();
        }
    }

    public void setGreenLight(boolean greenLight) {
        this.greenLight = greenLight;
        if (greenLight) {
            text = "";
            isFront = true;
        } else {
            isFront = false;
            if (characterPositions[0].y < gamePanel.map.getStartY() && characterPositions[0].y > gamePanel.map.getFinishY()) {
                text = "Mugunghwa-kkochi Pieossseubnida";
            }
        }
    }

    public void startGame() {
        gameRunning = true;
        greenLight = false;
        gameOver = false;
        countdown = 3;

        gameLoop();
    }

    public void stopGame() {
        gameRunning = false;
    }

    private void gameLoop() {
        while (gameRunning) {
            if (greenLight) {
                if (!gameOver) {
                    characterPositions[0].x = catcher.x;
                    characterPositions[0].y = catcher.y;
                    for (int i = 1; i < characterPositions.length; i++) {
                        Bot bot = gamePanel.panelBot.bot.get(i - 1);
                        characterPositions[i].x = bot.x;
                        characterPositions[i].y = bot.y;
                    }
                    // Check for catches, countdown, etc.
                    // ...
                }
            } else {
                try {
                    gameLogicSemaphore.acquire();
                    // Game logic for red light phase
                    for (int i = 0; i < characterPositions.length; i++) {
                        characterPositions[i].x = catcher.x;
                        characterPositions[i].y = catcher.y;
                        if (i > 0) {
                            Bot bot = gamePanel.panelBot.bot.get(i - 1);
                            characterPositions[i].x = bot.x;
                            characterPositions[i].y = bot.y;
                        }
                    }

                    // Add logic for random red light duration (8-10 seconds)
                    int redLightDuration = random.nextInt(3) + 8; // Random value between 8 and 10
                    Thread.sleep(redLightDuration * 1000); // Convert to milliseconds
                    gameLogicSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            gamePanel.catcher.displayText(text);
            gamePanel.catcher.setIsFront(isFront);

            gamePanel.panelBot.updateBotState(characterPositions); // Update bot state with character positions

            // Render the game state
            gamePanel.repaint();

            try {
                Thread.sleep(10); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Other methods for game logic control (e.g., catching players, countdown, game over, etc.)
    // ...
}
