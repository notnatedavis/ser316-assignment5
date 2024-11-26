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
    public static int returnValidIntInput(Scanner scanner, int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                //System.out.println(e);
            }
        }
    }
}