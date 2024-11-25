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
}