/**
 * EventEffect.java
 * logic\EventEffect
 * 
 * @author Nathaniel Davis-Perez [ndavispe]
 * @since 11/25/2024
 */

package logic;

import models.Startup;

public interface EventEffect {
    void applyEffect(Startup startup);
}