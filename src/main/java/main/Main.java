/**
 * Main.java
 * main\Main
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/19/2024
 */

package main;

import builder.TechGiantBuilder;
import models.Startup;
import singleton.GameManager;

public class Main {
    public static void main(String[] args) {
        // build Player Tech Giant
        Startup startup = new Startup(); // player's startup decided here, make so player has 3 choices (random startup, random startup of type, or select specific startup)
        TechGiantBuilder builder = new TechGiantBuilder();
        builder.setName("playerName").setInitialFunds(999).setStartup(startup); // fix&modify

        // create Tech Giants
        GameManager gameManager = GameManager.getInstance();
        gameManager.initializeGame(builder.build(), builder.setName("botName").build()); // update so that both players start with same funds

        // start Game
        System.out.println("Game Initialized!");
    }
}
