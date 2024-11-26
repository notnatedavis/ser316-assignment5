package logic;

import java.util.Scanner;

/**
 * InputHandler.java
 * logic\InputHandler
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */
public class InputHandler {
    /**
     * The public static int method (returnValidIntInput) prompts the user to
     * enter a valid integer within specified range
     * 
     * @param scanner
     * @param min
     * @param max
     * @return
     */
    public static int returnValidIntInput(Scanner scanner, int min, int max) {
        // declare variables
        int input;

        // infinite loop till valid input returned
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine()); // convert String -> int
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                //System.out.println(e);
            }
        }
    }
}