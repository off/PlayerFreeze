package com.glenjendary.PlayerFreeze;

/* PlayerFreeze Created by Glenjendary on 9/07/2017. */

import com.glenjendary.PlayerFreeze.commands.Freeze;
import com.glenjendary.PlayerFreeze.events.AuthorJoin;
import com.glenjendary.PlayerFreeze.events.Frozen;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        registerCommands();
        registerEvents();

        logger.info(pdfFile.getName() + " has been enabled with version "
                + pdfFile.getVersion());

    }

    public void registerCommands() {

        getCommand("freeze").setExecutor(new Freeze(this));

    }

    public void registerEvents() {

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new AuthorJoin(this), this);
        pm.registerEvents(new Frozen(this), this);

    }

    public void onDisable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been disabled with version "
                + pdfFile.getVersion());
    }

}
