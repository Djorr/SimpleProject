package com.djorr.simpleproject.player;

import com.djorr.simpleproject.player.profiles.SimplePlayer;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PlayerManager {

    private static @Getter PlayerManager instance;

    public Map<UUID, SimplePlayer> players;

    public PlayerManager() {
        instance = this;

        this.players = new HashMap<>();
    }

    public SimplePlayer setupPlayer(Player player) {
        SimplePlayer p;

        p = this.players.get(player.getUniqueId());

        if (p != null)
            return p;

        p = new SimplePlayer(player);

        this.players.put(player.getUniqueId(), p);

        return p;
    }

    public SimplePlayer getPlayer(Player player) {
        SimplePlayer p;

        p = this.players.get(player.getUniqueId());

        return p;
    }

    public void loadPlayerData(Player player) {

        SimplePlayer simplePlayer = this.setupPlayer(player);
        simplePlayer.setLoaded(true);

    }

    public void savePlayerData(Player player) {
        SimplePlayer simplePlayer = this.setupPlayer(player);
        simplePlayer.setLoaded(false);

        this.players.remove(player.getUniqueId(), player);

    }
}
