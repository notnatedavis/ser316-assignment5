/*
package logic;

import models.Startup;
import models.TechGiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import logic.GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * This file is for JUnit tests to build reports for code coverage (doesnt work)
 * wont recognize JUnit imports ?
 * 
class GameEngineTest {

    // declare instances
    private GameEngine gameEngine;
    private TechGiant playerTechGiant;
    private TechGiant botTechGiant;
    private List<Startup> playerStartups;
    private List<Startup> botStartups;

    @BeforeEach
    void setUp() {
        gameEngine = new GameEngine();

        // initialize startups with the full constructor
        playerStartups = new ArrayList<>();
        botStartups = new ArrayList<>();

        // startups
        Startup startup1 = new Startup(
            "Test (player) Startup", 
            "Medical", 
            1000.0,  // revenue
            200.0, // netIncome
            10.0,// marketShare
            50.0,      // price
            "attack 1", 
            "attack 2", 
            "attack 3"
        );

        Startup startup2 = new Startup(
            "Test (bot) Startup", 
            "Military", 
            800.0,   // revenue
            100.0, // netIncome
            8.0, // marketShare
            40.0,      // price
            "attack 1", 
            "attack 2", 
            "attack 3"
        );

        playerStartups.add(startup1);
        botStartups.add(startup2);

        // initialize TechGiant objects
        playerTechGiant = new TechGiant("Player", playerStartups);
        botTechGiant = new TechGiant("Bot", botStartups);
    }

    @Test
    @DisplayName("Test (Event) Economic Downturn")
    void testApplyEconomicDownturn() {
        gameEngine.applyEconomicDownturn(playerTechGiant);

        assertEquals(800.0, playerStartups.get(0).getRevenue()); // 20% decrease of 1000.0
        assertEquals(640.0, playerStartups.get(1).getRevenue()); // 20% decrease of 800.0
    }

    @Test
    @DisplayName("Test (Event) Regulatory Scrutiny")
    void testApplyRegulatoryScrutiny() {
        gameEngine.applyRegulatoryScrutiny(playerTechGiant);

        assertEquals(900.0, playerStartups.get(0).getRevenue()); // 10% increase of 1000.0
        assertEquals(720.0, playerStartups.get(1).getRevenue()); // 10% decrease of 800.0
    }

    @Test
    @DisplayName("Test reduce all startup revenues")
    void testReduceAllStartupRevenues() {
        gameEngine.reduceAllStartupRevenues(playerTechGiant, 0.2);

        assertEquals(800.0, playerStartups.get(0).getRevenue()); // 20% decrease of 1000.0
        assertEquals(640.0, playerStartups.get(1).getRevenue()); // 20% decrease of 800.0
    }

    @Test
    @DisplayName("Test increase all startup revenues")
    void testIncreaseAllStartupRevenues() {
        gameEngine.increaseAllStartupRevenues(playerTechGiant, 0.2);

        assertEquals(1200.0, playerStartups.get(0).getRevenue()); // 20% increase of 1000.0
        assertEquals(960.0, playerStartups.get(1).getRevenue()); // 20% increase of 800.0
    }

    @Test
    @DisplayName("Test (Event) Market Crash")
    void testHandleEvent_MarketCrash() {
        gameEngine.handleEvent(playerTechGiant, botTechGiant, "Market Crash");

        assertEquals(800.0, playerStartups.get(0).getRevenue()); // 20% decrease of 1000.0
        assertEquals(640.0, playerStartups.get(1).getRevenue()); // 20% decrease of 800.0
    }

    @Test
    @DisplayName("Test (Event) Market Boom")
    void testHandleEvent_MarketBoom() {
        gameEngine.handleEvent(playerTechGiant, botTechGiant, "Market Boom");

        assertEquals(1200.0, playerStartups.get(0).getRevenue()); // 20% increase of 1000.0
        assertEquals(960.0, playerStartups.get(1).getRevenue()); // 20% increase of 800.0
    }

    @Test
    @DisplayName("Test (Event) Housing Crisis")
    void testHandleEvent_HousingCrisis() {
        gameEngine.handleEvent(playerTechGiant, botTechGiant, "Housing Crisis");

        assertEquals(900.0, playerStartups.get(0).getRevenue()); // 10% decrease of 1000.0
        assertEquals(720.0, playerStartups.get(1).getRevenue()); // 10% decrease of 800.0
    }

    @Test
    @DisplayName("Test (Event) Housing Boom")
    void testHandleEvent_HousingBoom() {
        gameEngine.handleEvent(playerTechGiant, botTechGiant, "Housing Boom");

        assertEquals(1100.0, playerStartups.get(0).getRevenue()); // 10% increase of 1000.0
        assertEquals(880.0, playerStartups.get(1).getRevenue()); // 10% increase of 800.0
    }
}
*/