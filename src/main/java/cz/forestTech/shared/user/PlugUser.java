package cz.forestTech.shared.user;

import cz.forestTech.bungee.TheBungee;
import cz.forestTech.shared.platform.PlatformType;
import cz.forestTech.spigot.TheSpigot;

public class PlugUser {

    public PlugUser() {

    }

    public Object getUser(PlatformType type, String name) {
        switch (type) {
            case SPIGOT:
                return getSpigotUser(name);
            case BUNGEE:
                return getBungeeUser(name);
            default:
                throw new IllegalArgumentException("Invalid type of user!");
        }
    }

    private Object getSpigotUser(String name) {
        return TheSpigot.getInstance().getUserManager().getPlugUser(name);
    }

    private Object getBungeeUser(String name) {
        return TheBungee.getInstance().getUserManager().getPlugUser(name);
    }


}
