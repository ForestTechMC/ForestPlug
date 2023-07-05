package cz.forestTech.spigot.user.listener;

import cz.forestTech.spigot.TheSpigot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlugUserListener {

    private TheSpigot plugin;

    public PlugUserListener() {
        this.plugin = TheSpigot.getInstance();
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        plugin.getUserManager().newPlugUser(player);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        plugin.getUserManager().newPlugUser(player);
    }



}
