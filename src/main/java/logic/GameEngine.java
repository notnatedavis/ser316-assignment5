/**
 * GameEngine.java
 * logic\GameEngine
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

package logic;

import data.StartupData;
import models.Startup;
import models.TechGiant;

import java.util.List;
import java.util.Scanner;

public class GameEngine {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // setup game here
        System.out.println("Initializing game . . .");

        // Step 1 : load startup data
        List<Startup> startups = StartupData.initializeStartups();

        // display available startups
        System.out.println("\nAvailable Startups:");
        for (Startup startup : startups) {
            System.out.println(startup);
        }

        // Step 2 : player and bot startup selection
        Startup playerStartup = StartupSelector.selectStartup(scanner, startups);
        Startup botStartup = StartupSelector.selectRandomStartup(startups);

        // Step 3 : initialize Tech Giants
        TechGiant playerTechGiant = new TechGiant("Player Tech Giant", 0.0, playerStartup);
        TechGiant botTechGiant = new TechGiant("Bot Tech Giant", 0.0, botStartup);

        // Step 4 : start yearly loop
        int year = 1980;
        boolean gameRunning = true;

         while (gameRunning) {
            // pretty print year
            System.out.println("\n--- Year " + year + " ---");

            for (int quarter = 1; quarter <= 4; quarter++) {
                System.out.println("\nQuarter " + quarter);

                switch (quarter) {
                    case 1, 3 -> handlePlayerActions(scanner, playerTechGiant);
                    case 2 -> handleEvent(playerTechGiant, botTechGiant);
                    case 4 -> handleBattle(playerTechGiant, botTechGiant);
                }

                // Check if the game should end after this quarter
                if (checkGameOver(playerTechGiant, botTechGiant)) {
                    gameRunning = false;
                    break;
                }
            }

            year++;
        }

        System.out.println("game over !");
        scanner.close();
    }
    
    private void handlePlayerActions(Scanner scanner, TechGiant playerTechGiant) {
        System.out.println("\nPlayer Actions Menu:");
        System.out.println("1. Invest in your startup");
        System.out.println("2. Buy a new startup");
        System.out.println("3. Sell a startup");
        System.out.println("4. Skip this turn");

        int choice = InputHandler.returnValidIntInput(scanner, 1, 4);

        switch (choice) {
            case 1 -> playerTechGiant.investInStartup(scanner);
            case 2 -> playerTechGiant.buyStartup(scanner);
            case 3 -> playerTechGiant.sellStartup(scanner);
            case 4 -> System.out.println("Skipping this turn...");
        }
    }

    private void handleEvent(TechGiant playerTechGiant, TechGiant botTechGiant) {
        System.out.println("\nQuarterly Event!");
        // Placeholder for event logic
        System.out.println("Random events implemented here");
    }

    private void handleBattle(TechGiant playerTechGiant, TechGiant botTechGiant) {
        System.out.println("\nQuarterly Battle!");
        // Placeholder for battle logic
        System.out.println("Battle mechanics implemented here");
    }

    private boolean checkGameOver(TechGiant playerTechGiant, TechGiant botTechGiant) {
        if (!playerTechGiant.hasStartups()) {
            System.out.println("\nYou have been eliminated, Game Over");
            return true;
        }
    
        if (!botTechGiant.hasStartups()) {
            System.out.println("\nYou have defeated the Bot Tech Giant! You Win!");
            return true;
        }
    
        return false;
    }
}