package com.flox.spawners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SpawnerShopGUI {

    public static void openShop(Player player, int page) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Flox Spawner Shop (Seite " + (page + 1) + ")");

        SpawnerType[] types = SpawnerType.values();
        int perPage = 45;
        int maxPages = (int) Math.ceil((double) types.length / perPage);

        int start = page * perPage;
        int end = Math.min(start + perPage, types.length);

        for (int i = start; i < end; i++) {
            SpawnerType type = types[i];
            ItemStack icon = new ItemStack(type.getIcon());
            ItemMeta meta = icon.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.GOLD + type.getDisplayName() + " Spawner");
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "Preis: " + ChatColor.GREEN + type.getBasePrice() + " Coins");
                lore.add("");
                lore.add(ChatColor.YELLOW + "Klicke zum Kaufen!");
                meta.setLore(lore);
                icon.setItemMeta(meta);
            }
            inv.setItem(i - start, icon);
        }

        if (page > 0) {
            inv.setItem(45, createNavButton(Material.ARROW, ChatColor.YELLOW + "Vorherige Seite"));
        }
        if (page < maxPages - 1) {
            inv.setItem(53, createNavButton(Material.ARROW, ChatColor.YELLOW + "Nächste Seite"));
        }

        player.openInventory(inv);
    }

    private static ItemStack createNavButton(Material mat, String name) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
        return item;
    }
}