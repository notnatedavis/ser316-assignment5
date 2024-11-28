package logic;

import models.Startup;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom; // spotbugs

/**
 * StartupSelector.java
 * logic\StartupSelector
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

public class StartupSelector {

    private static final SecureRandom secureRandom = new SecureRandom(); // safer random

    /**
     * Handles initial startup selection process when starting
     * 
     * @param scanner
     * @param startups
     * @return
     */
    public static Startup selectStartup(Scanner scanner, List<Startup> startups) {
        
        // create infinite loop till valid choice
        while (true) {

            // print starting selection menu
            System.out.println("\nStartup Selection Menu");
            System.out.println("1. Select a random startup");
            System.out.println("2. Select a random startup of specific type");
            System.out.println("3. Select a specific startup");
            System.out.println("4. Cancel Selection");

            // store choice using input handler
            int choice = InputHandler.returnValidIntInput(scanner, 1, 4);

            // switch case for corresponding menu
            switch (choice) {
                case 1:
                    return selectRandomStartup(startups);
                case 2: 
                    return selectRandomStartupByType(scanner, startups);
                case 3:
                    return selectSpecificStartup(scanner, startups);
                case 4:
                    System.out.println("Startup Selection canceled");
                    return null;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Randomly selects a startup from list
     * 
     * @param startups
     * @return
     */
    public static Startup selectRandomStartup(List<Startup> startups) {
        int index = secureRandom.nextInt(startups.size()); // rolls a random int size of startups
        Startup choice = startups.get(index);
        System.out.println("Randomly selected startup: " + choice.getName() + " (" + choice.getType() + ")");
        return choice;
    }

    /**
     * Randomly select a startup from a specific type
     * 
     * @param scanner
     * @param startups
     * @return
     */
    private static Startup selectRandomStartupByType(Scanner scanner, List<Startup> startups) {
        // prompt player menu 
        System.out.println("\nSelect a Startup Type:");
        System.out.println("1. Social Media");
        System.out.println("2. Medical");
        System.out.println("3. Military");
        System.out.println("4. Tech");
        System.out.println("5. Financial Tech");
        System.out.println("6. Cancel");

        // store choice using input handler
        int choice = InputHandler.returnValidIntInput(scanner, 1, 6);

        if (choice == 6) { // Exit Check
            System.out.println("Type selection canceled.");
            return null;
        }

        // store values of starting index for each type (known from StartupData.java)
        int[] typeRanges = {
            0,  // Start index for : Social Media
            4,  // Start index for : Medical
            7,  // Start index for : Military
            10, // Start index for : Tech
            14  // Start index for : Financial Tech
        };

        int startIndex = typeRanges[choice - 1]; // select respective start
        // calculate endIndex based on choice of type
        int endIndex = (choice == typeRanges.length) ? startups.size() : typeRanges[choice];

        // select a random startup from selected type
        int randomIndex = startIndex + secureRandom.nextInt(endIndex - startIndex);
        Startup selected = startups.get(randomIndex);

        // print to player & update
        System.out.println("Randomly selected startup of type : " + selected.getName());
        return selected;
    }

    /**
     * Select specific startup from all startups
     * 
     * @param scanner
     * @param startups
     * @return
     */
    private static Startup selectSpecificStartup(Scanner scanner, List<Startup> startups) {
        System.out.println("\nSelect a Startup :");

        // list all startups
        for (int i = 0; i < startups.size(); i++) {
            System.out.println((i + 1) + ". " + startups.get(i).getName() + " (" + startups.get(i).getType() + ")"); // pretty print results
        }

        // include cancel option on menu
        System.out.println((startups.size() + 1) + ". Cancel"); // +1 option to cancel

        // store choice using input handler
        int choice = InputHandler.returnValidIntInput(scanner, 1, startups.size() + 1);

        if (choice == startups.size() + 1) { // Exit Check
            System.out.println("Specific startup selection canceled."); ///////
            return null;
        }

        Startup selected = startups.get(choice - 1);
        // print to player & update
        System.out.println("Selected startup: " + selected.getName());
        return selected;
    }
}