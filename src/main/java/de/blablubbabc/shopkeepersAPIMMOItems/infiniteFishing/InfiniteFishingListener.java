package de.blablubbabc.shopkeepersAPIMMOItems.infiniteFishing;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import io.lumine.mythic.lib.api.item.NBTItem;

public class InfiniteFishingListener implements Listener {

    @EventHandler
    public void onFishingStart(Event event) {
        if (event.getClass().getName()
                .equals("com.infinitefishing.events.PlayerStartFishingEvent")) {
            cleanBaitTags(event);
        }
    }

    @EventHandler
    public void onFishingStop(Event event) {
        if (event.getClass().getName()
                .equals("com.infinitefishing.events.PlayerStopFishingEvent")) {
            cleanBaitTags(event);
        }
    }

    @EventHandler
    public void onPlayerFish(Event event) {
        if (event.getClass().getName()
                .equals("com.infinitefishing.events.PlayerFishEvent")) {
            cleanBaitTags(event);
        }
    }

    private void cleanBaitTags(Event event) {
        try {
            ItemStack rod = (ItemStack) event.getClass().getMethod("getRod")
                    .invoke(event);
            if (rod != null && !rod.getType().isAir()) {
                NBTItem nbtItem = NBTItem.get(rod);
                for (int i = 0; i < 10; i++) {
                    nbtItem.removeTag("bait" + i);
                }
            }
        } catch (Exception ignored) {
        }
    }
}
