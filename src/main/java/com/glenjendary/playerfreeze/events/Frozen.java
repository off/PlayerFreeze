package com.glenjendary.playerfreeze.events;

import com.glenjendary.playerfreeze.Main;
import com.glenjendary.playerfreeze.commands.Freeze;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/* playerfreeze Created by Glenjendary on 9/07/2017. */

public class Frozen implements Listener {

    private Main plugin;

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event) {

        if(!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player target = event.getPlayer();

        if (Freeze.frozen.contains(target)) {
            event.setCancelled(true);
            target.sendMessage(ChatColor.RED + "You are frozen, follow the instructions of a staff member!");
        } else if (!(Freeze.frozen.contains(target))) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerDamage (EntityDamageByEntityEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player target = (Player) event.getEntity();

        if (Freeze.frozen.contains(target)) {
            event.setCancelled(true);
            if (event.getDamager() instanceof Player) {
                event.getDamager().sendMessage(ChatColor.RED.toString() + target + " is currently frozen!");
            }
        } else if (!(Freeze.frozen.contains(target))) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerQuit (PlayerQuitEvent event) {

        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player target = event.getPlayer();

        if (Freeze.frozen.contains(target)) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.hasPermission("freeze.notify")) {
                    all.sendMessage(ChatColor.BLUE + "[SC] " + target + " has left the server while frozen!");
                }
            }

            Freeze.frozen.remove(target);
        } else if (!(Freeze.frozen.contains(target))) {
            return;
        }
    }

    @EventHandler
    public void onBlockBreak (BlockBreakEvent event) {

        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player target = event.getPlayer();

        if (Freeze.frozen.contains(target)) {
            event.setCancelled(true);
            target.sendMessage(ChatColor.RED + "You are frozen, follow the instructions of a staff member!");
        } else if (!(Freeze.frozen.contains(target))) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockPlace (BlockPlaceEvent event) {

        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player target = event.getPlayer();

        if (Freeze.frozen.contains(target)) {
            event.setCancelled(true);
            target.sendMessage(ChatColor.RED + "You are frozen, follow the instructions of a staff member!");
        } else if (!(Freeze.frozen.contains(target))) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerDropItem (PlayerDropItemEvent event) {

        if (!(event.getPlayer() instanceof Player)) {
            return;
        }

        Player target = event.getPlayer();

        if (Freeze.frozen.contains(target)) {
            event.setCancelled(true);
            target.sendMessage(ChatColor.RED + "You are frozen, follow the instructions of a staff member!");
        } else if (!(Freeze.frozen.contains(target))) {
            event.setCancelled(false);
        }
    }
}
