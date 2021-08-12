package fr.tetemh.borderplugin;

import fr.tetemh.borderplugin.commands.CommandBorder;
import fr.tetemh.borderplugin.listeners.BListener;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable(){
        WorldBorder wb = getServer().getWorld("world").getWorldBorder();

        wb.setSize(0, 0);
        wb.setCenter(0, 0);

        getServer().getPluginManager().registerEvents(new BListener(), this);
        getCommand("setBorder").setExecutor(new CommandBorder());
    }
}
