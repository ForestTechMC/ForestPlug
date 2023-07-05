package cz.forestTech.addons;


import cz.forestTech.shared.platform.PlatformType;
import cz.forestTech.spigot.TheSpigot;

import java.util.HashMap;

public class ForestAddonAPI {


    public ForestAddonAPI() {

    }


    public void register(PlatformType type, ForestAddon forestAddon) {
        switch (type) {
            case BUNGEE:
                break;
            case SPIGOT:
                TheSpigot.getInstance().getAddonManager().addAddon(forestAddon);
                break;
        }

    }

    public void unRegister(PlatformType type, ForestAddon forestAddon) {
        switch (type) {
            case SPIGOT:
                TheSpigot.getInstance().getAddonManager().addAddon(forestAddon);
                break;
            case BUNGEE:
                break;
        }
    }

    public HashMap<String, ForestAddon> getAddons() {
        return TheSpigot.getInstance().getAddonManager().getAddonHashMap();
    }

}
