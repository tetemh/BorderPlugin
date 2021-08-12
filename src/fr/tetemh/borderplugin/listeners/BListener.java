package fr.tetemh.borderplugin.listeners;

import fr.tetemh.borderplugin.Main;
import fr.tetemh.borderplugin.commands.CommandBorder;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BListener implements Listener {

    private static double wbSize = 1;

    public static double getSize(){
        return wbSize;
    }


    @EventHandler
    public static void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        InventoryAction action = event.getAction();
        ItemStack itemStack = event.getCurrentItem();

        if(event.getInventory().getName().equals("§e§lWorld Border")){
            event.setCancelled(true);
        }

        if(itemStack.getType() == Material.STAINED_GLASS_PANE && itemStack.hasItemMeta() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§a+100 Block")) {
            WorldBorder wb = player.getWorld().getWorldBorder();
            wb.setSize(wb.getSize() + 100);
            wbSize = wb.getSize();
            event.getInventory().setItem(13, new CommandBorder().barrierBlock.build());
        }

        if(itemStack.getType() == Material.BARRIER && itemStack.hasItemMeta() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§4RESET")) {
            WorldBorder wb = player.getWorld().getWorldBorder();
            wb.reset();
            wb.setSize(0, 0);
            wbSize = wb.getSize();
            event.getInventory().setItem(13, new CommandBorder().barrierBlock.build());
        }

        if(itemStack.getType() == Material.STAINED_GLASS_PANE && itemStack.hasItemMeta() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§c-100 Block")) {
            WorldBorder wb = player.getWorld().getWorldBorder();
            wb.setSize(wb.getSize() - 100);
            wbSize = wb.getSize();
            event.getInventory().setItem(13, new CommandBorder().barrierBlock.build());
        }


    }
}
