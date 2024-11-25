/**
 * TechGiant.java
 * models\TechGiant
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/19/2024
 */

package models;

//import x; // might need

public class TechGiant {
    private String name;
    private double funds;
    private Startup startup;

    public TechGiant(String name, double funds, Startup startup) {
        this.name = name;
        this.funds = funds;
        this.startup = startup;
    }

    // getters + setters + other logic
}