package com.djorr.simpleproject.listeners;

import com.djorr.simpleproject.SimpleProject;
import com.djorr.simpleproject.player.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    public PlayerJoinQuitListener() {
        SimpleProject.getInstance().registerListener(this);
    }

    private PlayerManager playerManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        this.playerManager.loadPlayerData(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        this.playerManager.savePlayerData(event.getPlayer());
    }

}
