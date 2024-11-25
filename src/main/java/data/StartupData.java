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
            new Startup("Instagram", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Snapchat", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Pinterest", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Facebook", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0),

            // Medical
            new Startup("Pfizer", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Johnson&Johnson", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Bayer", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0),

            // Military
            new Startup("Boeing", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Lockheed Martin", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Raytheon", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0),

            // Tech
            new Startup("Apple", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Google", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Amazon", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Microsoft", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),

            // Financial Tech
            new Startup("Chase", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("PayPal", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("JPMorgan", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0),
            new Startup("Venmo", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0)
        );
    }
}