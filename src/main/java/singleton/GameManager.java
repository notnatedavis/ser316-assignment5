/**
 * GameManager.java
 * singleton\GameManager
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/19/2024
 */

package singleton;

import models.TechGiant;

public class GameManager {
    private static GameManager instance;
    private TechGiant player;
    private TechGiant bot;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void initializeGame(TechGiant player, TechGiant bot) {
        this.player = player;
        this.bot = bot;
    }

    public TechGiant getPlayer() {
        return player;
    }

    public TechGiant getBot() {
        return bot;
    }
}