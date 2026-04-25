package de.blablubbabc.shopkeepersAPIMMOItems.infiniteFishing;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InfiniteFishingListener implements Listener {

    @EventHandler
    public void onFishingStart(Event event) {
        // Listen to Infinite Fishing events but don't modify items
        // ItemUpdater handles item updates via Shopkeepers events
        if (event.getClass().getName()
                .equals("com.infinitefishing.events.PlayerStartFishingEvent")) {
            // Event captured, Shopkeepers will handle item matching
        }
    }

    @EventHandler
    public void onFishingStop(Event event) {
        if (event.getClass().getName()
                .equals("com.infinitefishing.events.PlayerStopFishingEvent")) {
            // Event captured
        }
    }

    @EventHandler
    public void onPlayerFish(Event event) {
        if (event.getClass().getName()
                .equals("com.infinitefishing.events.PlayerFishEvent")) {
            // Event captured
        }
    }
}

