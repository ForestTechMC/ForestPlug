package cz.forestTech.addons;


import org.bukkit.plugin.Plugin;

public abstract class ForestAddon {
    protected Plugin plugin;

    public ForestAddon(Plugin plugin) {
        this.plugin = plugin;
    }

    public abstract String name();
    public abstract Plugin plugin();
    public abstract String author();
    public abstract String describe();

}
