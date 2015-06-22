package com.hyperfresh.mcspells;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Keito on 6/20/2015.
 */
public class SpellsPlugin extends JavaPlugin {
    public static ItemStack boltbook;

    public void onEnable(){

        boltbook = new ItemStack(Material.BOOK,1);
        ItemMeta meta = boltbook.getItemMeta();
        meta.setDisplayName("bolt1");
        boltbook.setItemMeta(meta);

        this.getCommand("boltbook").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if(sender instanceof Player){
                    ((Player)sender).getInventory().setItemInHand(boltbook);
                }

                return true;
            }
        });
        this.getServer().getPluginManager().registerEvents(new SpellsListener(),this);
    }
    public void onDisable(){}
}
