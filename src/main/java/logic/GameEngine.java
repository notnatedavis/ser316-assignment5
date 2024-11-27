package logic;

import data.StartupData;
import models.Startup;
import models.TechGiant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GameEngine.java
 * logic\GameEngine
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */
public class GameEngine {

    // begins game
    public void startGame() {

        //  upon starting always . . .

        // initialize scanner & update player
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initializing game . . .");

        // 1. load StartupData & local clone
        List<Startup> startups = StartupData.initializeStartups();
        List<Startup> availableStartups = new ArrayList<>(startups);

        // 2. display available startups
        System.out.println("\nAvailable Startups:");
        for (Startup startup : availableStartups) {
            System.out.println(startup);
        }

        // 3. player and bot startup selection
        Startup playerStartup = StartupSelector.selectStartup(scanner, availableStartups);
        Startup botStartup = StartupSelector.selectRandomStartup(availableStartups);

        // 4. initialize Tech Giants
        TechGiant playerTechGiant = new TechGiant("Player Tech Giant", 250_000.0, playerStartup);
        TechGiant botTechGiant = new TechGiant("Bot Tech Giant", 250_000.0, botStartup);

        // 5. start yearly loop
        int year = 1980; // predefined year
        boolean gameRunning = true;

         while (gameRunning) { // main loop (game offically running)
            // pretty print year
            System.out.println("\n--- Year " + year + " ---");

            // Quarterly cycle with actions , events , and battles
            for (int quarter = 1; quarter <= 4; quarter++) {
                System.out.println("\nQuarter " + quarter);

                switch (quarter) {
                    case 1, 3 -> handlePlayerActions(scanner, playerTechGiant, availableStartups);
                    case 2 -> handleEvent(playerTechGiant, botTechGiant);
                    case 4 -> handleBattle(playerTechGiant, botTechGiant);
                }

                // Game over check after each quarter
                if (checkGameOver(playerTechGiant, botTechGiant)) {
                    gameRunning = false;
                    break;
                }
            }

            year++;
        }

        // 6. game over
        System.out.println("game over !");
        scanner.close();
    }
    
    /**
     * Handles all player actions within game
     * 
     * @param scanner
     * @param playerTechGiant
     * @param availableStartups
     */
    private void handlePlayerActions(Scanner scanner, TechGiant playerTechGiant, List<Startup> availableStartups) {
        // print menu
        System.out.println("\nPlayer Actions Menu:");
        System.out.println("1. Invest in your startup");
        System.out.println("2. Buy a new startup");
        System.out.println("3. Sell a startup");
        System.out.println("4. Skip this turn");

        // store choice and select corresponding menu option
        int choice = InputHandler.returnValidIntInput(scanner, 1, 4);

        switch (choice) {
            case 1 -> playerTechGiant.investInStartup(scanner);
            case 2 -> playerTechGiant.buyStartup(scanner, availableStartups); // pass availableStartups  list
            case 3 -> playerTechGiant.sellStartup(scanner);
            case 4 -> System.out.println("Skipping this turn...");
        }
    }

    /**
     * Handles all events within game
     * 
     * @param playerTechGiant
     * @param botTechGiant
     */
    private void handleEvent(TechGiant playerTechGiant, TechGiant botTechGiant) {
        System.out.println("\nQuarterly Event!");
        
        // list of events
        String[] events = {
            "Corporate Tax Cuts",
            "Economic Downturn",
            "Regulatory Scrutiny",
            "Market Crash",
            "Market Boom",
            "Housing Crisis",
            "Housing Boom"
        };

        // randomly select an event
        String event = events[(int) (Math.random() * events.length)];
        System.out.println("Event : " + event);

        // apply event effects
        switch (event) {
            case "Corporate Tax Cuts" -> {
                System.out.println("Neutral event. No changes this quarter.");
            }
            case "Economic Downturn" -> {
                // apply event to both
                applyEconomicDownturn(playerTechGiant);
                applyEconomicDownturn(botTechGiant);
            }
            case "Regulatory Scrutiny" -> {
                // apply event to both
                applyRegulatoryScrutiny(playerTechGiant);
                applyRegulatoryScrutiny(botTechGiant);
            }
            case "Market Crash" -> {
                // apply event to both
                reduceAllStartupRevenues(playerTechGiant, 0.2); // Reduce by 20%
                reduceAllStartupRevenues(botTechGiant, 0.2);
            }
            case "Market Boom" -> {
                // apply event to both
                increaseAllStartupRevenues(playerTechGiant, 0.2); // Boost by 20%
                increaseAllStartupRevenues(botTechGiant, 0.2);
            }
            case "Housing Crisis" -> {
                // apply event to both
                reduceAllStartupRevenues(playerTechGiant, 0.1); // Reduce by 10%
                reduceAllStartupRevenues(botTechGiant, 0.1);
            }
            case "Housing Boom" -> {
                // apply event to both
                increaseAllStartupRevenues(playerTechGiant, 0.1); // Boost by 10%
                increaseAllStartupRevenues(botTechGiant, 0.1);
            }
        }
    }

    /**
     * Handles battles between players within game
     * 
     * @param playerTechGiant
     * @param botTechGiant
     */
    private void handleBattle(TechGiant playerTechGiant, TechGiant botTechGiant) {
        System.out.println("\nQuarterly Battle!");
        
        // choose startups for battle
        Startup playerStartup = selectStartupForBattle(playerTechGiant);
        Startup botStartup = selectStartupForBattle(botTechGiant);
        
        System.out.println("Battle: " + playerStartup.getName() + " vs " + botStartup.getName()); // pretty print

        // battle continues until one startup's revenue drops to 0
        while (playerStartup.getRevenue() > 0 && botStartup.getRevenue() > 0) {
            // player chooses attack
            int playerChoice = getPlayerAttackChoice(playerStartup);
            executePlayerAttack(playerChoice, playerStartup, botStartup);
            if (botStartup.getRevenue() <= 0) break; // if bot dies

            // bot chooses random attack
            int botChoice = getRandomAttackChoice(); //
            executeBotAttack(botChoice, botStartup, playerStartup);
        }

        // determine winner and apply results
        if (playerStartup.getRevenue() > 0) {
            System.out.println(playerStartup.getName() + " wins!");
            playerTechGiant.setFunds(playerTechGiant.getFunds() + 500); // Reward funds // UPDATE
            boostAttributes(playerStartup, 0.1); // Boost attributes by 10%
        } else {
            System.out.println(botStartup.getName() + " wins!");
            botTechGiant.setFunds(botTechGiant.getFunds() + 500); // Reward funds
            reduceAttributes(playerStartup, 0.1); // Reduce attributes by 10%
        }
    }

    /**
     * Checks if either player has startups (game over condition)
     * 
     * @param playerTechGiant
     * @param botTechGiant
     * @return
     */
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

    /**
     * Event (Economic Downturn) w/ corresponding effects to startups
     * 
     * @param techGiant
     */
    private void applyEconomicDownturn(TechGiant techGiant) {
        for (Startup startup : techGiant.getStartups()) {
            if (startup.getType().equalsIgnoreCase("Healthcare")) {
                startup.increaseRevenueByPercentage(0.2); // Boost by 20%
                System.out.println(startup.getName() + " (Healthcare) benefits: +20% revenue.");
            } else if (startup.getType().equalsIgnoreCase("FinTech")) {
                startup.decreaseRevenueByPercentage(0.2); // Reduce by 20%
                System.out.println(startup.getName() + " (FinTech) suffers: -20% revenue.");
            }
        }
    }

    /**
     * Event (Regulatory Scrutiny) w/ corresponding effects to startups
     * 
     * @param techGiant
     */
    private void applyRegulatoryScrutiny(TechGiant techGiant) {
        for (Startup startup : techGiant.getStartups()) {
            if (startup.getMarketShare() > 25.0) {
                startup.decreaseRevenueByPercentage(0.1); // Reduce revenue by 10%
                System.out.println(startup.getName() + " has high market share: -10% revenue.");
            } else {
                startup.increaseRevenueByPercentage(0.1); // Boost revenue by 10%
                System.out.println(startup.getName() + " has low market share: +10% revenue.");
            }
        }
    }

    /**
     * Reduces all TechGiant's startup revenue (health) by percentage
     * 
     * @param techGiant
     * @param percentage
     */
    private void reduceAllStartupRevenues(TechGiant techGiant, double percentage) {
        for (Startup startup : techGiant.getStartups()) {
            startup.decreaseRevenueByPercentage(percentage);
            System.out.println(startup.getName() + " revenue reduced by " + (percentage * 100) + "%.");
        }
    }
    
    /**
     * Increases all TechGiant's startup revenue (health) by percentage
     * 
     * @param techGiant
     * @param percentage
     */
    private void increaseAllStartupRevenues(TechGiant techGiant, double percentage) {
        for (Startup startup : techGiant.getStartups()) {
            startup.increaseRevenueByPercentage(percentage);
            System.out.println(startup.getName() + " revenue increased by " + (percentage * 100) + "%.");
        }
    }

    /**
     * Selects 1st owned startup for battle (FIFO)
     * 
     * @param techGiant
     * @return
     */
    private Startup selectStartupForBattle(TechGiant techGiant) {
        return techGiant.getStartups().get(0); // always selects the first startup
    }

    /**
     * Increases all attributes for startup by percentage
     * 
     * @param startup
     * @param percentage
     */
    private void boostAttributes(Startup startup, double percentage) {
        startup.increaseRevenueByPercentage(percentage);
        startup.increaseMarketShareByPercentage(percentage);
        startup.increaseNetIncomeByPercentage(percentage);
    }

    /**
     * Decreases all attributes for startup by percentage
     * 
     * @param startup
     * @param percentage
     */
    private void reduceAttributes(Startup startup, double percentage) {
        startup.decreaseRevenueByPercentage(percentage);
        startup.decreaseMarketShareByPercentage(percentage);
        startup.decreaseNetIncomeByPercentage(percentage);
    }

    private int getPlayerAttackChoice(Startup playerStartup) {
        Scanner scanner = new Scanner(System.in); // create scanner instance for input

        // print menu
        System.out.println("\nChoose your attack:");
        System.out.println("1. " + playerStartup.getAttack1());
        System.out.println("2. " + playerStartup.getAttack2());
        System.out.println("3. " + playerStartup.getAttack3());

        return InputHandler.returnValidIntInput(scanner, 1, 3);
    }

    private void executePlayerAttack(int choice, Startup playerStartup, Startup botStartup) {
        switch (choice) {
            case 1 -> playerStartup.executeAttack1(botStartup);
            case 2 -> playerStartup.executeAttack2(botStartup);
            case 3 -> playerStartup.executeAttack3(botStartup);
        }
    }

    private int getRandomAttackChoice() {
        return (int) (Math.random() * 3) + 1; // roll random 1-3
    }

    private void executeBotAttack(int choice, Startup botStartup, Startup playerStartup) {
        System.out.println("\n" + botStartup.getName() + " is plotting your defeat...");
        switch (choice) {
            case 1 -> botStartup.executeAttack1(playerStartup);
            case 2 -> botStartup.executeAttack2(playerStartup);
            case 3 -> botStartup.executeAttack3(playerStartup);
        }
    }
}