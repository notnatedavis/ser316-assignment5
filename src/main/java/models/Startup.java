/**
 * Startup.java
 * models\Startup
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

package models;

public class Startup {
    private String name;
    private String type;
    private double revenue;
    private double netIncome;
    private double marketShare;

    // constructor
    public Startup(String name, String type, double revenue, double netIncome, double marketShare) {
        this.name = name;
        this.type = type;
        this.reveneue = revenue;
        this.netIncome = netIncome;
        this.marketShare = marketShare;
    }

    // getters & setters
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getRevenue() {
        return revenue;
    }
    public double getNetIncome() {
        return netIncome;
    }
    public double getMarketShare() {
        return marketShare;
    }
}