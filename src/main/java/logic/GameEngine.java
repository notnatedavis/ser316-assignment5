/**
 * GameEngine.java
 * logic\GameEngine
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

package logic;

import java.util.Scanner;

public class GameEngine {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // setup game here

        System.out.println("Initializing game . . .");

        // logic for setting up Tech Giants & Startups

        boolean gameRunning = true;
        while (gameRunning) {
            // Player Turn
            System.out.println("\nPlayer's turn");

            // handle player actions

            // Bot Turn
            System.out.println("\nBot's turn");

            // handle bot actions

            // Check gameOver condition
            gameRunning = checkGameOver();
        }

        System.out.println("game over !");
        scanner.close();
    }
    
    private boolean checkGameOver() {
        // implement game over logic
        return false;
    }
}