package data;

import models.Startup;
import java.util.ArrayList; // not needed ?
import java.util.Arrays;
import java.util.List;

/**
 * StartupData.java
 * data\StartupData
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

public class StartupData {
    // creates a predefined list of Startups w/ Arrays.asList()
    public static List<Startup> initializeStartups() {
        return Arrays.asList(
            // Social Media
            new Startup("Instagram", "Social Media", 2_100, 250, 11.0, 450, "Influencer Invasion", "Story Swipe", "Filter Frenzy"), // # 1
            new Startup("Snapchat" , "Social Media", 2_000, 240, 9.0, 400, "Snap Surge", "Selfie Snatch", "Ghost Protocol"), // # 2
            new Startup("Pinterest", "Social Media", 1_900, 240, 10.0, 400, "Pinpoint Precision", "Board Bombardment", "Pinning Panic"), // # 3
            new Startup("Facebook" , "Social Media", 2_200, 260, 12.0, 500, "Like Lockdown", "Timeline Takedown", "Feed Frenzy"), // # 4

            // Medical
            new Startup("Pfizer"         , "Medical", 4_000, 220, 17.0, 1_000, "Vaccine Vengeance", "Pill Push", "Cure Crash"), // # 5
            new Startup("Johnson&Johnson", "Medical", 4_000, 210, 16.0, 950, "Bandage Blockade", "Surgical Strike", "Healing Havoc"), // # 6
            new Startup("Bayer"          , "Medical", 4_000, 200, 15.0, 900, "Pill Pulverizer", "Formula Fiasco", "Prescription Panic"), // # 7

            // Military
            new Startup("Boeing"         , "Military", 2_500, 355, 21.0, 1_500, "Missile Strike", "Jetstream Juggernaut", "Aerospace Assault"), // # 8
            new Startup("Lockheed Martin", "Military", 2_500, 350, 20.0, 1_400, "Stealth Strike", "Radar Rip", "Lockdown Launch"), // # 9
            new Startup("Raytheon"       , "Military", 2_500, 340, 19.0, 1_300, "Missile Mayhem", "Radar Rampage", "Target Lock"), // # 10

            // Tech
            new Startup("Apple"    , "Tech", 2_300, 310, 13.0, 700, "iPad Brainwash", "Siri Shutdown", "App Attack"), // # 11
            new Startup("Google"   , "Tech", 2_200, 300, 12.0, 660, "Search Surge", "Algorithm Ambush", "Data Dive"), // # 12
            new Startup("Amazon"   , "Tech", 2_100, 290, 11.0, 620, "Prime Pounce", "Cart Capture", "Delivery Drop"), // # 13
            new Startup("Microsoft", "Tech", 2_000, 280, 10.0, 580, "Windows Wipeout", "Software Siege", "Cloud Crash"), // # 14

            // Financial Tech
            new Startup("Chase"   , "Financial Tech", 3_100, 220, 15.0, 750, "Banking Blitz", "Credit Crunch", "Vault Vanquish"), // # 15
            new Startup("PayPal"  , "Financial Tech", 3_000, 210, 14.0, 730, "Payback Payback", "Transfer Takedown", "Payment Plunge"), // # 16
            new Startup("JPMorgan", "Financial Tech", 2_900, 200, 13.0, 710, "Stock Stomp", "Ledger Lock", "Wall Street Wreck"), // # 17
            new Startup("Venmo"   , "Financial Tech", 2_800, 190, 12.0, 690, "Cash Clash", "Transaction Trap", "Pay-off Plunge")  // # 18
        );
    }
}