package com.afatcookie.inventoryplugin.inventoryplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Inventoryplugin extends JavaPlugin {

    private static Inventoryplugin plugin;

    public static Inventoryplugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new InventoryFull(), this);
        CommandsManager.CommandList(this);
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }
}
