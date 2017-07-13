package com.glenjendary.playerfreeze;

/* playerfreeze Created by Glenjendary on 9/07/2017. */

import com.glenjendary.playerfreeze.commands.Freeze;
import com.glenjendary.playerfreeze.events.AuthorJoin;
import com.glenjendary.playerfreeze.events.Frozen;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        getCommand("freeze").setExecutor(new Freeze());
        getServer().getPluginManager().registerEvents(new AuthorJoin(), this);
        getServer().getPluginManager().registerEvents(new Frozen(), this);
    }
}
