/**
 * Main.java
 * main\Main
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

package main;

import logic.GameEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("Silicon-Valley Simulator");
        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
    }
}
