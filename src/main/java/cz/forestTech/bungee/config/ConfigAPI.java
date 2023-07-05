package cz.forestTech.bungee.config;


import lombok.SneakyThrows;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ConfigAPI {

    // Your plugin
    private Plugin plugin;

    // Name of file
    private String fileName;

    // The file
    private File file;

    /**
     * Constructor for config
     *
     * @param plugin   Your plugin
     * @param fileName name of the file, we want to modify
     */
    public ConfigAPI(Plugin plugin, String fileName) {
        this.plugin = plugin;
        if (!fileName.contains(".yml")) {
            fileName = fileName + ".yml";
        }

        this.fileName = fileName;
        this.file = new File(plugin.getDataFolder(), fileName);
    }

    /**
     * This is the essential method for using the whole config
     *
     * @return options like normal config
     */
    @SneakyThrows
    public Configuration getConfig() {
        return ConfigurationProvider
                .getProvider(YamlConfiguration.class)
                .load(file);
    }

    /**
     * This method is the same as reload, because Bungee provider method for load do this two things
     */
    @SneakyThrows
    public void save() {
        ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
    }

    /**
     * Same as save method
     */
    @SneakyThrows
    public void reload() {
        ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
    }

    /**
     * We can see, here we create config, and copy resource into
     */
    @SneakyThrows
    public void create() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        if (!file.exists()) {
            FileOutputStream outputStream = new FileOutputStream(file);
            InputStream in = plugin.getResourceAsStream(fileName);
            in.transferTo(outputStream);
        }
    }

}

