package com.djorr.simpleproject.player.profiles;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SimplePlayer {

    private Player player;
    private UUID uuid;
    private String name;

    private @Getter
    @Setter
    boolean loaded;

    private String lastIP;

    public SimplePlayer(Player player) {
        this.player = player;
        this.uuid = player.getUniqueId();
        this.name = player.getName();

        this.loaded = false;

        this.lastIP = player.getAddress().getHostName();
    }

    // --- UUID ---

    public UUID getUuid() {
        return this.uuid;
    }

    // --- Player ---

    public Player getPlayer() {
        return this.player;
    }

    // --- Name ---

    public String getName() {
        return this.name;
    }

    // --- Last IP ---

    public String getIP() { return this.lastIP; }

}
