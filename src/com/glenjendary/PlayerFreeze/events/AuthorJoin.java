package com.glenjendary.PlayerFreeze.events;

import com.glenjendary.PlayerFreeze.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/* PlayerFreeze Created by Glenjendary on 9/07/2017. */

public class AuthorJoin implements Listener {

    private Main plugin;
    public AuthorJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (player.getUniqueId().toString().replace("-", "") == "e06c919d712b408a8fff3bd16512ee12") {
            player.sendMessage(ChatColor.RED + "Server is running your PlayerFreeze plugin!");
        }

    }

}
