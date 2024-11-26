/**
 * StartupData.java
 * data\StartupData
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/19/2024
 */

package data;

import models.Startup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartupData {
    public static List<Startup> initializeStartups() {
        return Arrays.asList(
            // Social Media
            new Startup("Instagram", "Social Media", 1_000_000, 15.0, 200_000, 800_000, 0.1, 0.05, 0), // # 1
            new Startup("Snapchat", "Social Media", 900_000, 12.0, 180_000, 750_000, 0.12, 0.06, 0),  // # 2
            new Startup("Pinterest", "Social Media", 850_000, 10.0, 150_000, 700_000, 0.09, 0.04, 0), // # 3
            new Startup("Facebook", "Social Media", 2_000_000, 25.0, 300_000, 1_200_000, 0.15, 0.08, 0), // # 4

            // Medical
            new Startup("Pfizer", "Medical", 3_000_000, 20.0, 500_000, 1_500_000, 0.1, 0.05, 0),  // # 5
            new Startup("Johnson&Johnson", "Medical", 2_800_000, 18.0, 450_000, 1_400_000, 0.1, 0.05, 0), // # 6
            new Startup("Bayer", "Medical", 2_500_000, 15.0, 400_000, 1_300_000, 0.08, 0.04, 0),   // # 7

            // Military
            new Startup("Boeing", "Military", 4_000_000, 25.0, 600_000, 2_000_000, 0.12, 0.06, 0), // # 8
            new Startup("Lockheed Martin", "Military", 3_800_000, 22.0, 550_000, 1_900_000, 0.11, 0.05, 0), // # 9
            new Startup("Raytheon", "Military", 3_500_000, 20.0, 500_000, 1_800_000, 0.1, 0.04, 0), // # 10

            // Tech
            new Startup("Apple", "Tech", 5_000_000, 35.0, 800_000, 2_500_000, 0.15, 0.08, 0),      // # 11
            new Startup("Google", "Tech", 4_800_000, 30.0, 750_000, 2_400_000, 0.14, 0.07, 0),     // # 12
            new Startup("Amazon", "Tech", 4_500_000, 28.0, 700_000, 2_300_000, 0.13, 0.06, 0),     // # 13
            new Startup("Microsoft", "Tech", 5_200_000, 32.0, 850_000, 2_600_000, 0.16, 0.09, 0),  // # 14

            // Financial Tech
            new Startup("Chase", "Financial Tech", 3_000_000, 20.0, 400_000, 1_500_000, 0.1, 0.05, 0), // # 15
            new Startup("PayPal", "Financial Tech", 2_800_000, 18.0, 380_000, 1_400_000, 0.1, 0.05, 0), // # 16
            new Startup("JPMorgan", "Financial Tech", 2_600_000, 16.0, 350_000, 1_300_000, 0.09, 0.04, 0), // # 17
            new Startup("Venmo", "Financial Tech", 2_500_000, 15.0, 340_000, 1_250_000, 0.08, 0.04, 0)     // # 18
        );
    }
}