package com.hyperfresh.mcspells;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.EnumSet;

/**
 * Created by Keito on 6/20/2015.
 */
public class SpellsListener implements Listener{

    public static final int distance = 128; //How far you can cast your spells based on block distance
    public static final int magicUse = 2; //Mana depletion from hunger bar
    public static int coolDowntime = 2500;
    public static long supercomplexspelldelayname = 0; //have fun debugging this you fucks

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){

        if(event.getPlayer().getItemInHand() .equals(SpellsPlugin.boltbook)){

            Player player = event.getPlayer();
            long time = System.currentTimeMillis();

            if(time - supercomplexspelldelayname >= coolDowntime && player.getFoodLevel() >= magicUse){

                Location location = player.getTargetBlock(EnumSet.of(Material.AIR) , distance).getLocation();
                location.getWorld().strikeLightning(location);
                player.setFoodLevel(player.getFoodLevel() - magicUse);

                supercomplexspelldelayname = time;
            }
            else{
                player.sendMessage("Need more mana!");
            }

        }
    }
}
