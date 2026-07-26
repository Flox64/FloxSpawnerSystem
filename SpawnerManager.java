package com.flox.spawners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class SpawnerManager {

    private static NamespacedKey typeKey;
    private static NamespacedKey countKey;

    public static void init(FloxSpawners plugin) {
        typeKey = new NamespacedKey(plugin, "spawner_type");
        countKey = new NamespacedKey(plugin, "spawner_count");
    }

    public static ItemStack createSpawnerItem(SpawnerType type, int count) {
        ItemStack item = new ItemStack(Material.SPAWNER);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.GOLD + "✦ " + ChatColor.YELLOW + type.getDisplayName() + " Spawner");
            
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Anzahl: " + ChatColor.WHITE + count);
            lore.add("");
            lore.add(ChatColor.YELLOW + "Platziere diesen Spawner,");
            lore.add(ChatColor.YELLOW + "um " + type.getDisplayName() + " zu spawnen!");
            meta.setLore(lore);

            PersistentDataContainer pdc = meta.getPersistentDataContainer();
            pdc.set(typeKey, PersistentDataType.STRING, type.name());
            pdc.set(countKey, PersistentDataType.INTEGER, count);

            item.setItemMeta(meta);
        }
        return item;
    }

    public static SpawnerType getSpawnerType(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return null;
        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();
        if (pdc.has(typeKey, PersistentDataType.STRING)) {
            String name = pdc.get(typeKey, PersistentDataType.STRING);
            return SpawnerType.fromString(name);
        }
        return null;
    }

    public static int getSpawnerCount(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return 1;
        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();
        return pdc.getOrDefault(countKey, PersistentDataType.INTEGER, 1);
    }
}