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
import java.util.List;

public class StartupData {
    public static List<Startup> getAllStartups() {
        List<Startup> startups = new ArrayList<>();

        // Social Media
        startups.add(new Startup("Instagram", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Snapchat", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Pinterest", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Facebook", "Social Media", 0.0, 0, 0, 0, 0.0, 0.0, 0));

        // Medical
        startups.add(new Startup("Pfizer", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Johnson&Johnson", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Bayer", "Medical", 0.0, 0, 0, 0, 0.0, 0.0, 0));

        // Military
        startups.add(new Startup("Boeing", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Lockheed Martin", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Raytheon", "Military", 0.0, 0, 0, 0, 0.0, 0.0, 0));

        // Tech
        startups.add(new Startup("Apple", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Google", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Amazon", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Microsoft", "Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));

        // Financial Tech
        startups.add(new Startup("Chase", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("PayPal", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("JPMorgan", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        startups.add(new Startup("Venmo", "Financial Tech", 0.0, 0, 0, 0, 0.0, 0.0, 0));
        
        return startups;
    }
}