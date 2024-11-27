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
            new Startup("Instagram", "Social Media", 1_000_000, 200_000, 15.0, 100, "A1", "A2", "A3"),  // # 1
            new Startup("Snapchat", "Social Media", 900_000, 180_000, 12.0, 100, "B1", "B2", "B3"),    // # 2
            new Startup("Pinterest", "Social Media", 850_000, 150_000, 10.0, 100, "C1", "C2", "C3"),   // # 3
            new Startup("Facebook", "Social Media", 2_000_000, 300_000, 25.0, 100, "D1", "D2", "D3"),  // # 4

            // Medical
            new Startup("Pfizer", "Medical", 3_000_000, 500_000, 20.0, 100, "E1", "E2", "E3"),         // # 5
            new Startup("Johnson&Johnson", "Medical", 2_800_000, 450_000, 18.0, 100, "F1", "F2", "F3"),// # 6
            new Startup("Bayer", "Medical", 2_500_000, 400_000, 15.0, 100, "G1", "G2", "G3"),          // # 7

            // Military
            new Startup("Boeing", "Military", 4_000_000, 600_000, 25.0, 100, "H1", "H2", "H3"),        // # 8
            new Startup("Lockheed Martin", "Military", 3_800_000, 550_000, 22.0, 100, "I1", "I2", "I3"),// # 9
            new Startup("Raytheon", "Military", 3_500_000, 500_000, 20.0, 100, "J1", "J2", "J3"),      // # 10

            // Tech
            new Startup("Apple", "Tech", 5_000_000, 800_000, 35.0, 100, "K1", "K2", "K3"),             // # 11
            new Startup("Google", "Tech", 4_800_000, 750_000, 30.0, 100, "L1", "L2", "L3"),            // # 12
            new Startup("Amazon", "Tech", 4_500_000, 700_000, 28.0, 100, "M1", "M2", "M3"),            // # 13
            new Startup("Microsoft", "Tech", 5_200_000, 850_000, 32.0, 100, "N1", "N2", "N3"),         // # 14

            // Financial Tech
            new Startup("Chase", "Financial Tech", 3_000_000, 400_000, 20.0, 100, "O1", "O2", "O3"),   // # 15
            new Startup("PayPal", "Financial Tech", 2_800_000, 380_000, 18.0, 100, "P1", "P2", "P3"),  // # 16
            new Startup("JPMorgan", "Financial Tech", 2_600_000, 350_000, 16.0, 100, "Q1", "Q2", "Q3"),// # 17
            new Startup("Venmo", "Financial Tech", 2_500_000, 340_000, 15.0, 100, "R1", "R2", "R3")    // # 18
        );
    }
}