package cz.forestTech.spigot.user.manager;

import cz.forestTech.spigot.TheSpigot;
import cz.forestTech.spigot.user.model.SpigotUser;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class UserManager {

    private TheSpigot plugin;

    private boolean isAllowed;

    private HashMap<String, SpigotUser> plugUserHashMap;

    public UserManager() {
        this.plugin = TheSpigot.getInstance();
        loadData();
    }

    private void loadData() {
        plugUserHashMap = new HashMap<>();

    }

    public void newPlugUser(Player player) {
        long currentTime = System.currentTimeMillis();

        if (getPlugUserHashMap().containsKey(player.getName().toLowerCase())) {
            SpigotUser spigotUser = getPlugUser(player);
            spigotUser.setLastJoin(currentTime);

            updatePlugUser(spigotUser);
            return;
        }

        SpigotUser spigotUser = new SpigotUser(
                player.getName(),
                player.getUniqueId(),
                currentTime,
                currentTime,
                new HashMap<>()
        );
        addPlugUserToHashMap(spigotUser);
        return;
        // TODO DB
    }

    public void removePlugUser(SpigotUser user) {
        removePlugUserFromHashMap(user);
        return;
        // TODO DB
    }

    public void updatePlugUser(SpigotUser user) {
        if (!getPlugUserHashMap().containsKey(user.getName().toLowerCase())) {
            return;
        }

        getPlugUserHashMap().replace(user.getName().toLowerCase(), user);
        return;
        // TODO DB
    }


    private HashMap<String, SpigotUser> getPlugUserHashMap() {
        return plugUserHashMap;
    }


    private void addPlugUserToHashMap(SpigotUser user) {
        plugUserHashMap.put(user.getName().toLowerCase(), user);
    }

    private void removePlugUserFromHashMap(SpigotUser user) {
        plugUserHashMap.remove(user.getName().toLowerCase());
    }

    public SpigotUser getPlugUser(String name) {
        return plugUserHashMap.get(name.toLowerCase());
    }

    public SpigotUser getPlugUser(Player player) {
        return plugUserHashMap.get(player.getName().toLowerCase());
    }

}
