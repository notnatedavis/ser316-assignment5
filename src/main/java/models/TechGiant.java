/**
 * TechGiant.java
 * models\TechGiant
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logic.InputHandler;

public class TechGiant {
    private String name;
    private double funds;
    private List<Startup> startups;

    public TechGiant(String name, double funds) {
        this.name = name;
        this.funds = funds;
        this.startups = new ArrayList<>();
    }

    public void addStartup(Startup startup) {
        startups.add(startup);
    }
    public void removeStartup(Startup startup) {
        startups.remove(startup);
    }
    public boolean hasStartups() {
        return !startups.isEmpty(); // returns T if not empty
    }

    public double getFunds() {
        return funds;
    }
    public void setFunds(double funds) {
        this.funds = funds;
    }
    public List<Startup> getStartups() {
        return startups;
    }

    public void investInStartup(Scanner scanner) {
        if (startups.isEmpty()) {
            System.out.println("No startups left to invest in");
            return;
        }

        System.out.println("Choose a startup to invest in");
        for (int i = 0; i < startups.size(); i++) {
            System.out.println((i + 1) + ". " + startups.get(i).getName());
        }

        int choice = InputHandler.returnValidIntInput(scanner, 1, startups.size());
        Startup selectedStartup = startups.get(choice - 1);

        System.out.println("Enter amount to invest : ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount > funds) {
            System.out.println("You can't afford that");
            return;
        }

        funds -= amount;
        selectedStartup.growFromInvestment(amount); //implement
        System.out.println("Successfuly invested : $" + amount + " into " + selectedStartup.getName());
    }

    public void buyStartup(Scanner scanner, List<Startup> availableStartups) {
        System.out.println("Available startups to buy : ");
        for (int i = 0; i < availableStartups.size(); i++) {
            System.out.println((i + 1) + ". " + availableStartups.get(i).getName() +
                    " ($" + availableStartups.get(i).getPrice() + ")");
        }
        int choice = InputHandler.returnValidIntInput(scanner, 1, availableStartups.size());
        Startup selectedStartup = availableStartups.get(choice - 1);

        if (selectedStartup.getPrice() > funds) {
            System.out.println("Not enough funds to buy this startup.");
            return;
        }

        funds -= selectedStartup.getPrice();
        addStartup(selectedStartup);
        availableStartups.remove(selectedStartup);
        System.out.println("Successfully bought " + selectedStartup.getName());
    }

    public void sellStartup(Scanner scanner) {
        if (startups.isEmpty()) {
            System.out.println("You have no startups to sell.");
            return;
        }

        System.out.println("Choose a startup to sell:");
        for (int i = 0; i < startups.size(); i++) {
            System.out.println((i + 1) + ". " + startups.get(i).getName());
        }
        int choice = InputHandler.returnValidIntInput(scanner, 1, startups.size());
        Startup selectedStartup = startups.get(choice - 1);

        funds += selectedStartup.getPrice();
        removeStartup(selectedStartup);
        System.out.println("Successfully sold " + selectedStartup.getName() + " for $" + selectedStartup.getPrice());
    }

    @Override
    public String toString() {
        return name + " [Funds: $" + funds + ", Startups: " + startups.size() + "]";
    }
}