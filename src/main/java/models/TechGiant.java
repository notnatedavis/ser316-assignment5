package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logic.InputHandler;

/**
 * TechGiant.java
 * models\TechGiant
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */
public class TechGiant {

    // declare variables
    private String name;
    private double funds;
    private List<Startup> startups;

    /**
     * Constructs new TechGiant with params
     * 
     * @param name
     * @param funds
     * @param initialStartup
     */
    public TechGiant(String name, double funds, Startup initialStartup) {
        this.name = name;
        this.funds = funds;
        this.startups = new ArrayList<>();
        this.startups.add(initialStartup);
    }

    /**
     * Adds startup to startup(s)
     * 
     * @param startup
     */
    public void addStartup(Startup startup) {
        startups.add(startup);
    }

    /**
     * Removes startup from startup(s)
     * 
     * @param startup
     */
    public void removeStartup(Startup startup) {
        startups.remove(startup);
    }

    /**
     * Checks if owns startups
     * 
     * @return
     */
    public boolean hasStartups() {
        return !startups.isEmpty(); // returns T if not empty
    }

    // getters  & setters
    public double getFunds() {
        return funds;
    }
    public void setFunds(double funds) {
        this.funds = funds;
    }
    public List<Startup> getStartups() {
        return startups;
    }

    /**
     * Allows TechGiant to invest in a startup from availableStartups,  
     * accessed from handlePlayerActions in GameEngine.java
     * 
     * @param scanner
     */
    public void investInStartup(Scanner scanner) {

        // 1. check if TechGiant owns startups
        if (startups.isEmpty()) {
            System.out.println("No startups left to invest in");
            return;
        }

        // 2.1 print available startups to invest in
        System.out.println("Choose a startup to invest in");
        for (int i = 0; i < startups.size(); i++) {
            System.out.println((i + 1) + ". " + startups.get(i).getName() + " (Level: " + startups.get(i).getLevel() + ", XP: " + startups.get(i).getXp() + ")"); // pretty print reslts
        }

        // 2.2 store choice and select corresponding startup
        int choice = InputHandler.returnValidIntInput(scanner, 1, startups.size());
        Startup selectedStartup = startups.get(choice - 1);

        // 3. calculate xp needed for next level + print along w/ funds
        double xpToNextLevel = selectedStartup.calculateXPThreshold() - selectedStartup.getXp();
        double dollarsToNextLevel = xpToNextLevel / Startup.XP_PER_DOLLAR; // Convert XP to dollars

        System.out.println(selectedStartup.getName() + " requires $" + dollarsToNextLevel + " to level up to Level " + (selectedStartup.getLevel() + 1)); // pretty print reslts
        System.out.println("Your current balance: $" + funds);

        // 4. prompt amount to invest
        System.out.println("Enter amount to invest : ");
        double amount = Double.parseDouble(scanner.nextLine());

        // 5. check if allowed
        if (amount > funds) {
            System.out.println("You're broke ! You can't afford that");
            return;
        }

        // 6. process transaction , update startup & inform player
        funds -= amount;
        selectedStartup.growFromInvestment(amount); // xp evolution mechanic in Startup.java
        System.out.println("Successfuly invested : $" + amount + " into " + selectedStartup.getName()); // pretty print reslts
    }

    /**
     * Allows TechGiant to buy a startup from availableStartups,
     * accessed from handlePlayerActions in GameEngine.java
     * 
     * @param scanner
     * @param availableStartups
     */
    public void buyStartup(Scanner scanner, List<Startup> availableStartups) {
        
        // 1.1 print available startups to buy
        System.out.println("Available startups to buy : ");
        for (int i = 0; i < availableStartups.size(); i++) {
            System.out.println((i + 1) + ". " + availableStartups.get(i).getName() + " ($" + availableStartups.get(i).getPrice() + ")"); // pretty print reslts
        }

        // 1.2 store choice and select corresponding startup
        int choice = InputHandler.returnValidIntInput(scanner, 1, availableStartups.size());
        Startup selectedStartup = availableStartups.get(choice - 1);

        // 2. check if allowed
        if (selectedStartup.getPrice() > funds) {
            System.out.println("You're broke ! You can't afford that");
            return;
        }

        // 3. process transaction , update startup & inform player
        funds -= selectedStartup.getPrice();
        addStartup(selectedStartup);
        availableStartups.remove(selectedStartup); // remove startup from availableStartups
        System.out.println("Successfully bought : " + selectedStartup.getName()); // pretty print reslts
    }

    /**
     * Allows TechGiant to sell an owned startup,
     * accessed from handlePlayerActions in GameEngine.java
     * 
     * @param scanner
     */
    public void sellStartup(Scanner scanner) {

        // 1. check if TechGiant owns startups
        if (startups.isEmpty()) {
            System.out.println("You own no startups to sell.");
            return;
        }

        // 2.1 print owned startups to sell
        System.out.println("Choose a startup to sell:");
        for (int i = 0; i < startups.size(); i++) {
            System.out.println((i + 1) + ". " + startups.get(i).getName()); // pretty print reslts
        }

        // 2.2 store choice and select corresponding startup
        int choice = InputHandler.returnValidIntInput(scanner, 1, startups.size());
        Startup selectedStartup = startups.get(choice - 1);

        // 3. process transaction , update startup & inform player
        funds += selectedStartup.getPrice();
        removeStartup(selectedStartup); // remove sold from owned startups
        System.out.println("Successfully sold " + selectedStartup.getName() + " for $" + selectedStartup.getPrice()); // pretty print reslts
    }

    // toString method for printing consistent updates
    @Override
    public String toString() {
        return name + " [Funds: $" + funds + ", Startups: " + startups.size() + "]"; // pretty print reslts
    }
}