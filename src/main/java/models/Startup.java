package models;

/**
 * Startup.java
 * models\Startup
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

public class Startup {
    private String name;
    private String type;
    private double revenue;
    private double marketShare;
    private double netIncome;
    private double price;

    // constructor
    public Startup(String name, String type, double revenue, double netIncome, double marketShare) {
        this.name = name;
        this.type = type;
        this.revenue = revenue;
        this.marketShare = marketShare;
        this.netIncome = netIncome;
        this.price = price;
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
    public void increaseRevenueByPercentage(double percentage) {
        revenue += revenue * percentage;
    }

    public void decreaseRevenueByPercentage(double percentage) {
        revenue -= revenue * percentage;
    }
    public double getNetIncome() {
        return netIncome;
    }
    public double getMarketShare() {
        return marketShare;
    }
    public double getPrice() {
        return price; // Getter for price
    }
    @Override
    public String toString() {
        return name + " [" + type + ", Revenue: $" + revenue + ", Price: $" + price + "]";
    }
}