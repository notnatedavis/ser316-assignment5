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
            new Startup("Instagram", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 1
            new Startup("Snapchat", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 2
            new Startup("Pinterest", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 3
            new Startup("Facebook", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 4

            // Medical
            new Startup("Pfizer", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 5
            new Startup("Johnson&Johnson", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 6
            new Startup("Bayer", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 7

            // Military
            new Startup("Boeing", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 8
            new Startup("Lockheed Martin", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 9
            new Startup("Raytheon", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 10

            // Tech
            new Startup("Apple", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 11
            new Startup("Google", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 12
            new Startup("Amazon", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 13
            new Startup("Microsoft", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 14 

            // Financial Tech
            new Startup("Chase", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 15
            new Startup("PayPal", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 16
            new Startup("JPMorgan", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0), // # 17
            new Startup("Venmo", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0) // # 18
        );
    }
}