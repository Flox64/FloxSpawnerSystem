package com.flox.spawners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class FloxSpawners extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        SpawnerManager.init(this);
        getCommand("spawners").setExecutor(this);
        getServer().getPluginManager().registerEvents(new SpawnerListener(), this);
        getLogger().info("FloxSpawners wurde erfolgreich aktiviert! (55 Spawner geladen)");
    }

    @Override
    public void onDisable() {
        getLogger().info("FloxSpawners wurde deaktiviert.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von Spielern ausgeführt werden.");
            return true;
        }
        Player player = (Player) sender;
        SpawnerShopGUI.openShop(player, 0);
        return true;
    }
}