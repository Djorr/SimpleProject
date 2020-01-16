package com.djorr.simpleproject.listeners;

import com.djorr.simpleproject.SimpleProject;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    public PlayerChatListener() {
        SimpleProject.getInstance().registerListener(this);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        event.setFormat(ChatColor.GRAY + player.getName() + ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + event.getMessage());
    }

}
