/**
 * TechGiantBuilder.java
 * builder\TechGiantBuilder
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/19/2024
 */

package builder; // ? main.java.builder

import models.TechGiant;
import models.Startup;

public class TechGiantBuilder {
    private String name;
    private double initialFunds;
    private Startup startup;

    public TechGiantBuilder setName(String name) {
        this.name = name;
        return this; // ? is this necessary
    }

    public TechGiantBuilder setInitialFunds(double funds) {
        this.initialFunds = funds;
        return this;
    }

    public TechGiantBuilder setStartup(Startup startup) {
        this.startup = startup;
        return this;
    }

    public TechGiant build() {
        return new TechGiant(name, initialFunds, startup);
    }
}