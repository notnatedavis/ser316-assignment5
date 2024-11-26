package main;

import logic.GameEngine;

/**
 * Main.java
 * main\Main
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Silicon-Valley Simulator");
        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
    }
}
