package cz.forestTech.bungee.user.model;


import cz.forestTech.apis.colors.ColorAPI;
import cz.forestTech.apis.colors.ColorizeType;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
public class BungeeUser {

    private String name;

    private UUID uuid;

    private long firstJoin;
    private long lastJoin;

    private HashMap<String, Object> addonUser;

    public BungeeUser(String name, UUID uuid, long firstJoin, long lastJoin, HashMap<String, Object> addonUser) {
        this.name = name;
        this.uuid = uuid;
        this.firstJoin = firstJoin;
        this.lastJoin = lastJoin;
        this.addonUser = addonUser;
    }

    public void sendMessage(ColorizeType colorizeType, String message) {
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(name);
        assert player != null;

        player.sendMessage(ColorAPI.colorizeType(colorizeType, message));
        return;
    }

}
