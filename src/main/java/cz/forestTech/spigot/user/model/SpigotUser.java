package cz.forestTech.spigot.user.model;

import cz.forestTech.apis.colors.ColorAPI;
import cz.forestTech.apis.colors.ColorizeType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
public class SpigotUser {

    private String name;

    private UUID uuid;

    private long firstJoin;
    private long lastJoin;

    private HashMap<String, Object> addonUser;

    public SpigotUser(String name, UUID uuid, long firstJoin, long lastJoin, HashMap<String, Object> addonUser) {
        this.name = name;
        this.uuid = uuid;
        this.firstJoin = firstJoin;
        this.lastJoin = lastJoin;
        this.addonUser = addonUser;
    }

    public void sendMessage(ColorizeType colorizeType, String message) {
        Player player = Bukkit.getPlayer(name);
        assert player != null;

        player.sendMessage(ColorAPI.colorizeType(colorizeType, message));
        return;
    }

}
