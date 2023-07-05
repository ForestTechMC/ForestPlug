package cz.forestTech.bungee;

import cz.forestTech.addons.AddonLoader;
import cz.forestTech.bungee.user.manager.UserManager;
import cz.forestTech.shared.platform.PlatformType;
import net.md_5.bungee.api.plugin.Plugin;

public class TheBungee extends Plugin {

    private static TheBungee instance;

    private UserManager userManager;
    private AddonLoader addonLoader;

    @Override
    public void onEnable() {
        instance = this;

        addonLoader = new AddonLoader(PlatformType.BUNGEE);
        userManager = new UserManager();
    }

    @Override
    public void onDisable() {

    }

    public AddonLoader getAddonManager() {
        return addonLoader;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public static TheBungee getInstance() {
        return instance;
    }
}
