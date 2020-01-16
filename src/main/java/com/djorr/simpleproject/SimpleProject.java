package com.djorr.simpleproject;

import com.djorr.simpleproject.command.commands.CommandSpawn;
import com.djorr.simpleproject.listeners.PlayerChatListener;
import com.djorr.simpleproject.listeners.PlayerJoinQuitListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleProject extends JavaPlugin {

    private static @Getter SimpleProject instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        this.registerListeners();
        this.registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private void registerListeners() {
        new PlayerChatListener();
        new PlayerJoinQuitListener();

    }

    private void registerCommands() {
        new CommandSpawn("spawn", false);
    }
}
