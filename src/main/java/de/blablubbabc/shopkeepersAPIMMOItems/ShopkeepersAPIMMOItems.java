package de.blablubbabc.shopkeepersAPIMMOItems;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import de.blablubbabc.shopkeepersAPIMMOItems.itemUpdates.ItemUpdater;
import de.blablubbabc.shopkeepersAPIMMOItems.infiniteFishing.InfiniteFishingListener;

public class ShopkeepersAPIMMOItems extends JavaPlugin {

    private ItemUpdater itemUpdater;
    private InfiniteFishingListener infiniteFishingListener;

	@Override
    public void onEnable() {
        saveDefaultConfig();

        if (!Bukkit.getPluginManager().isPluginEnabled("Shopkeepers")) {
            getLogger().severe("Shopkeepers not found! Disabling plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if (Bukkit.getPluginManager().isPluginEnabled("MMOItems")) {
            getLogger().info("MMOItems detected. MMOItems support enabled.");
        } else {
            getLogger().warning("MMOItems not found. MMOItems items will NOT work.");
        }

        if (getConfig().getBoolean("enable-item-updater")) {
            this.itemUpdater = new ItemUpdater(this);
            itemUpdater.onEnable();
        }

        if (Bukkit.getPluginManager().isPluginEnabled("InfiniteFishing")) {
            this.infiniteFishingListener = new InfiniteFishingListener();
            Bukkit.getPluginManager().registerEvents(infiniteFishingListener, this);
            getLogger().info("InfiniteFishing detected. InfiniteFishing support enabled.");
        }
    }

	@Override
    public void onDisable() {
        if (itemUpdater != null) {
            itemUpdater.onDisable();
        }
        if (infiniteFishingListener != null) {
            HandlerList.unregisterAll(infiniteFishingListener);
        }
    }
}
