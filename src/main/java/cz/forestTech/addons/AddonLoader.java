package cz.forestTech.addons;


import cz.forestTech.bungee.TheBungee;
import cz.forestTech.shared.platform.PlatformType;
import cz.forestTech.spigot.TheSpigot;
import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;

import java.io.File;
import java.util.HashMap;

public class AddonLoader {
    private HashMap<String, ForestAddon> addonHashMap;

    private TheSpigot theSpigot;
    private TheBungee theBungee;

    public AddonLoader(PlatformType type) {
        addonHashMap = new HashMap<>();

        switch (type) {
            case SPIGOT -> theSpigot = TheSpigot.getInstance();
            case BUNGEE -> theBungee = TheBungee.getInstance();
        }

    }

    public void loadAddons() {
        PluginLoader pluginLoader = Bukkit.getPluginManager().getPlugin("ForestPlug").getPluginLoader();
        File pluginFolder = new File(theSpigot.getDataFolder().getParentFile(), "ForestPlug");

        if (pluginFolder.exists() && pluginFolder.isDirectory()) {
            File[] pluginFiles = pluginFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));

            if (pluginFiles != null) {
                for (File pluginFile : pluginFiles) {
                    Plugin plugin = null;
                    try {
                        plugin = pluginLoader.loadPlugin(pluginFile);
                    } catch (InvalidPluginException e) {
                        throw new RuntimeException(e);
                    }

                    if (plugin.isEnabled()) {
                        continue;
                    }

                    Bukkit.getPluginManager().enablePlugin(plugin);
                }
            }
        }
    }

    public void addAddon(ForestAddon addon) {
        getAddonHashMap().put(addon.name(), addon);
        System.out.println("ADDONY: " + getAddonHashMap().size());
    }

    public void remove(ForestAddon addon) {
        getAddonHashMap().remove(addon.name());
    }

    public HashMap<String, ForestAddon> getAddonHashMap() {
        return addonHashMap;
    }
}
