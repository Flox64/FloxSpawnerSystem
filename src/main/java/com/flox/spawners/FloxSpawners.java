package com.flox.spawners;

import org.bukkit.plugin.java.JavaPlugin;

public final class FloxSpawners extends JavaPlugin {
    private static FloxSpawners instance;
    private SpawnerManager spawnerManager;

    @Override
    public void onEnable() {
        instance = this;
        this.spawnerManager = new SpawnerManager();
        getServer().getPluginManager().registerEvents(new SpawnerListener(this), this);
        getLogger().info("FloxSpawners v1.0 enabled successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FloxSpawners disabled.");
    }

    public static FloxSpawners getInstance() { return instance; }
    public SpawnerManager getSpawnerManager() { return spawnerManager; }
}
