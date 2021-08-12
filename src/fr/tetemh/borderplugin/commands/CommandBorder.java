package fr.tetemh.borderplugin.commands;

import fr.tetemh.borderplugin.Main;
import fr.tetemh.borderplugin.listeners.BListener;
import fr.tetemh.borderplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class CommandBorder implements CommandExecutor {

    public Inventory inventory = Bukkit.createInventory(null, 3 * 9, "§e§lWorld Border");
    public ItemBuilder glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1).setName(" ").addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    public ItemBuilder glassGreen = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 5).setName("§a+100 Block").addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    public ItemBuilder glassRed = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).setName("§c-100 Block").addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    public ItemBuilder barrierBlock = new ItemBuilder(Material.BARRIER, 1).setName("§4RESET").setLore("§7Taille World Boarder : " + (BListener.getSize() - 1)).addItemFlags(ItemFlag.HIDE_ATTRIBUTES);


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            for (int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, glass.build());
            }

            inventory.setItem(12, glassGreen.build());
            inventory.setItem(13, barrierBlock.build());
            inventory.setItem(14, glassRed.build());

            player.openInventory(inventory);
        }

        return false;
    }
}
