package cz.forestTech.spigot;

import cz.forestTech.addons.AddonLoader;
import cz.forestTech.addons.ForestAddonAPI;
import cz.forestTech.shared.platform.PlatformType;
import cz.forestTech.spigot.config.ConfigAPI;
import cz.forestTech.spigot.user.manager.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;


public class TheSpigot extends JavaPlugin {

    private static TheSpigot instance;

    private UserManager userManager;
    private AddonLoader addonLoader;
    private ForestAddonAPI forestAddonAPI;
    private ConfigAPI modulesConfig;

    @Override
    public void onEnable() {
        instance = this;

        addonLoader = new AddonLoader(PlatformType.SPIGOT);
        addonLoader.loadAddons();
        forestAddonAPI = new ForestAddonAPI();
        userManager = new UserManager();
        enableMessage();
    }

    @Override
    public void onDisable() {

    }

    private void enableMessage() {
        Bukkit.getScheduler().runTaskLater(this, () -> {
            Bukkit.getLogger().log(Level.INFO, "_____________________________________");
            Bukkit.getLogger().log(Level.INFO, " ");
            Bukkit.getLogger().log(Level.INFO, "    "+ getDescription().getName() +" by "+ getDescription().getAuthors().get(0));
            Bukkit.getLogger().log(Level.INFO, " ");
            Bukkit.getLogger().log(Level.INFO, " Description: " + getDescription().getDescription());
            Bukkit.getLogger().log(Level.INFO, " Version: " + getDescription().getVersion());
            Bukkit.getLogger().log(Level.INFO, " ");
            Bukkit.getLogger().log(Level.INFO, " Discord: https://discord.com/invite/2PpdrfxhD4");
            Bukkit.getLogger().log(Level.INFO, " ");
            Bukkit.getLogger().log(Level.INFO, "______________________________________");
        }, 20 * 5);
    }

    public ForestAddonAPI getForestAddonAPI() {
        return forestAddonAPI;
    }

    public static TheSpigot getInstance() {
        return instance;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public ConfigAPI getModulesConfig() {
        return modulesConfig;
    }

    public AddonLoader getAddonManager() {
        return addonLoader;
    }
}
