package cz.forestTech.addons;

import cz.forestTech.spigot.Spigot;

import java.util.List;

public class ForestAddonAPI {

    private Spigot plugin;

    public ForestAddonAPI() {
        plugin = Spigot.getInstance();
    }


    public void register(ForestAddon forestAddon) {
        plugin.getAddonManager().addAddon(forestAddon);
    }

    public void unRegister(ForestAddon forestAddon) {
        plugin.getAddonManager().remove(forestAddon);
    }

    public List<ForestAddon> getAddons() {
        return plugin.getAddonManager().getAddonsList();
    }

}
