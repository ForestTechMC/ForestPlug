package cz.forestTech.addons;

import cz.forestTech.spigot.Spigot;
import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class AddonManager {
    private List<ForestAddon> addonsList;

    private Spigot plugin;

    public AddonManager() {
        plugin = Spigot.getInstance();
        addonsList = new ArrayList<>();
        loadAddons();
    }

    public void loadAddons() {
        PluginLoader pluginLoader = Bukkit.getPluginManager().getPlugin("ForestPlug").getPluginLoader();
        File pluginFolder = new File(plugin.getDataFolder().getParentFile(), "ForestPlug");

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
                    Bukkit.getPluginManager().enablePlugin(plugin);
                }
            }
        }
    }

    public List<ForestAddon> getAddonsList() {
        return addonsList;
    }

    public void addAddon(ForestAddon addon) {
        getAddonsList().add(addon);
    }

    public void remove(ForestAddon addon) {
        getAddonsList().remove(addon);
    }

}
