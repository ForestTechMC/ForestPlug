package cz.forestTech.spigot;

import cz.forestTech.addons.AddonManager;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;


public class Spigot extends JavaPlugin {

    private static Spigot instance;
    private AddonManager addonManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        addonManager = new AddonManager();


    }

    @Override
    public void onDisable() {

    }

    public static Spigot getInstance() {
        return instance;
    }

    public AddonManager getAddonManager() {
        return addonManager;
    }
}
