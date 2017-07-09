package com.glenjendary.PlayerFreeze.commands;

import com.glenjendary.PlayerFreeze.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/* PlayerFreeze Created by Glenjendary on 9/07/2017. */

public class Freeze implements CommandExecutor {
    private Main plugin;
    public Freeze(Main plugin) {
        this.plugin = plugin;
    }

    public static ArrayList<Player> frozen = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("freeze")) {
            if (args.length == 0 && sender.hasPermission("freeze.help")) {
                sender.sendMessage(ChatColor.RED + "Please use /freeze <player>");
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return false;
            } if (args.length == 1 && sender.hasPermission("freeze.others")) {
                Player target;
                try {
                    target = Bukkit.getPlayer(args[0]);

                } catch (NullPointerException e) {
                    sender.sendMessage(ChatColor.RED + args[0] + " is not a online player!");
                    target = null;
                    return false;
                }

                if (target.hasPermission("freeze.bypass")) {
                    sender.sendMessage(ChatColor.RED + "You cannot freeze this player!");
                    return false;
                }
                if (!(frozen.contains(target))) {
                    frozen.add(target);
                    target.sendMessage(ChatColor.RED + "You have been frozen, follow the instructions of a staff member!");
                } else if (frozen.contains(target)) {
                    frozen.remove(target);
                    target.sendMessage(ChatColor.GREEN + "You have been unfrozen, have a good day!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return false;
            }
        }
        return false;
    }
}
