package models;

/**
 * Startup.java
 * models\Startup
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */
public class Startup {
    
    // startup attributes
    private String name;
    private String type;
    private double revenue;
    private double marketShare;
    private double netIncome;
    private double price;
    private int level;
    private double xp;
    public static final double XP_PER_DOLLAR = 0.1; // 1 xp gained per $10
    private static final double BASE_XP_THRESHOLD = 100.0; // $1000 for 1 level up // update to be dynamic based on level (ie require more xp per level)
    private static final double SCALING_FACTOR = 1.5; // xp scaling rate per level
    
    // Unique attacks
    private String attack1; // x1 : reduces opponent's market share
    private String attack2; // x2 : reduces opponent's net income
    private String attack3; // x3 : reduces opponent's revenue

    // attack effects
    private int attack1Effect = 1; //temp
    private int attack2Effect = 1;
    private int attack3Effect = 1;

    /**
     * Constructs new Startup with params
     * 
     * @param name
     * @param type
     * @param revenue
     * @param netIncome
     * @param marketShare
     * @param price
     */
    public Startup(String name, String type, double revenue, double netIncome, double marketShare, double price, String attack1, String attack2, String attack3) {
        this.name = name;
        this.type = type;
        this.revenue = revenue; // Health
        this.marketShare = marketShare; // Defense
        this.netIncome = netIncome; // Attack Power
        this.price = price;
        this.level = 1; // start at level 1
        this.xp = 0; // start with 0 xp

        // initialize unique attacks
        this.attack1 = attack1; // market share
        this.attack2 = attack2; // net income
        this.attack3 = attack3; // revenue
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
    public double getMarketShare() {
        return marketShare;
    }
    public double getNetIncome() {
        return netIncome;
    }
    public double getPrice() {
        return price;
    }
    public int getLevel() {
        return level;
    }
    public double getXp() {
        return xp;
    }
    public String getAttack1() {
        return attack1;
    }
    public String getAttack2() {
        return attack2;
    }
    public String getAttack3() {
        return attack3;
    }
    public int getAttack1Effect() {
        return attack1Effect;
    }
    public int getAttack2Effect() {
        return attack2Effect;
    }
    public int getAttack3Effect() {
        return attack3Effect;
    }

    // +- Revenue by %
    public void increaseRevenueByPercentage(double percentage) {
        revenue += revenue * percentage;
    }
    public void decreaseRevenueByPercentage(double percentage) {
        revenue -= revenue * percentage;
    }

    // +- MarketShare by %
    public void increaseMarketShareByPercentage(double percentage) {
        marketShare += marketShare * percentage;
    }
    public void decreaseMarketShareByPercentage(double percentage) {
        marketShare -= marketShare * percentage;
    }

    // +- NetIncome by %
    public void increaseNetIncomeByPercentage(double percentage) {
        netIncome += netIncome * percentage;
    }
    public void decreaseNetIncomeByPercentage(double percentage) {
        netIncome -= netIncome * percentage;
    }

    // calculates xp required for startup to level up
    public double calculateXPThreshold() {
        return BASE_XP_THRESHOLD * Math.pow(level, SCALING_FACTOR);
    }

    /**
     * Calculates xp gained, adding to current startup xp and levels
     * up when applicable
     * 
     * @param amount
     */
    public void growFromInvestment(double amount) {

        // 1. calculate xp gain
        double gainXP = amount * XP_PER_DOLLAR;
        xp += gainXP;

        // 2. update player of status
        System.out.println(name + " gained " + gainXP + " XP");

        // 3. level-up check
        while (xp >= calculateXPThreshold()) {
            xp -= calculateXPThreshold(); // deduct XP needed to level up
            levelUp(); // trigger level up
        }
    }

    /**
     * Handles logic for when a startup levels up boosting its stats 
     * and updating player
     */
    private void levelUp() {
        level++; // increment
        // update player of status
        System.out.println(name + " leveled up, now level " + level);

        // boost attributes by some number
        revenue += revenue * 0.1; // increase revenue by 10%
        marketShare += marketShare * 0.1; // increase marketShare by 10%
        netIncome += netIncome * 0.1; // increase netIncome by 10%
    }

    public void executeAttack1(Startup opponent) {
        opponent.decreaseMarketShareByPercentage(attack1Effect / 100.0); // convert to %
        System.out.println(this.name + " used " + attack1 + " on " + opponent.getName());
    }

    public void executeAttack2(Startup opponent) {
        opponent.decreaseNetIncomeByPercentage(attack2Effect / 100.0);
        System.out.println(this.name + " used " + attack2 + " on " + opponent.getName());
    }
    
    public void executeAttack3(Startup opponent) {
        opponent.decreaseRevenueByPercentage(attack3Effect / 100.0);
        System.out.println(this.name + " used " + attack3 + " on " + opponent.getName());
    }

    // toString method for printing consistent updates
    @Override
    public String toString() {
        return name + " [" + type + ", Revenue: $" + revenue + ", Price: $" + price + "]";
    }
}