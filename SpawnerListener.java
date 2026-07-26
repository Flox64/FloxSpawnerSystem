package com.flox.spawners;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SpawnerListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().startsWith(ChatColor.DARK_GRAY + "Flox Spawner Shop")) {
            event.setCancelled(true);
            if (!(event.getWhoClicked() instanceof Player)) return;
            Player player = (Player) event.getWhoClicked();
            ItemStack clicked = event.getCurrentItem();
            if (clicked == null || !clicked.hasItemMeta()) return;

            String name = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());
            if (name.contains("Vorherige Seite") || name.contains("Nächste Seite")) {
                return;
            }

            for (SpawnerType type : SpawnerType.values()) {
                if (name.equalsIgnoreCase(type.getDisplayName() + " Spawner")) {
                    ItemStack spawnerItem = SpawnerManager.createSpawnerItem(type, 1);
                    player.getInventory().addItem(spawnerItem);
                    player.sendMessage(ChatColor.GREEN + "Du hast erfolgreich 1x " + type.getDisplayName() + " Spawner gekauft!");
                    player.closeInventory();
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        SpawnerType type = SpawnerManager.getSpawnerType(item);
        if (type != null) {
            Block block = event.getBlockPlaced();
            if (block.getState() instanceof CreatureSpawner) {
                CreatureSpawner spawner = (CreatureSpawner) block.getState();
                spawner.setSpawnedType(type.getEntityType());
                spawner.update();
                event.getPlayer().sendMessage(ChatColor.GREEN + "Spawner platziert: " + type.getDisplayName());
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getState() instanceof CreatureSpawner) {
            CreatureSpawner spawner = (CreatureSpawner) block.getState();
            if (spawner.getSpawnedType() != null) {
                SpawnerType type = SpawnerType.fromString(spawner.getSpawnedType().name());
                if (type != null) {
                    event.setDropItems(false);
                    ItemStack spawnerItem = SpawnerManager.createSpawnerItem(type, 1);
                    block.getWorld().dropItemNaturally(block.getLocation(), spawnerItem);
                    event.getPlayer().sendMessage(ChatColor.YELLOW + "Du hast einen " + type.getDisplayName() + " Spawner abgebaut!");
                }
            }
        }
    }
}