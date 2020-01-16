package com.djorr.simpleproject.player.data;

import com.djorr.simpleproject.SimpleProject;
import com.djorr.simpleproject.player.profiles.SimplePlayer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class DataProcessor {

    /**
     * Omdat de DataSaver en DataLoader classes ongeveer het zelfde zijn, maak ik gebruik van een abstract class om de structuur het zelfde te houden.
     */

    protected SimplePlayer player;

    public DataProcessor(SimplePlayer player) {
        this.player = player;

        queries();

        /**
         * We runnen process() ASync, omdat we hierin data versturen / opvragen vanuit de
         * database en dit kan erg zwaar zijn, dus willen we niet dat de rest van de plugin
         * die andere code runned hier last van hebt.
         */

        if (Bukkit.isPrimaryThread()) {
            Bukkit.getScheduler().runTaskAsynchronously(SimpleProject.getInstance(), this::process);
        } else {
            this.process();
        }

    }

    /**
     * Hier maak ik abstract voids, dit kunnen we gebruiken zodat we in elke class die we extenden van deze class deze functies hebben.
     * Dit is noodzakelijk, omdat we in elke Data class deze functies nodig hebben.
     */

    public abstract void queries();

    public abstract void process();

    /**
     * Dit is gewoon een functie die we kunnen gebruiken om de speler te kickan als bijvoorbeeld zijn data niet goed is ingeladen.
     */
    protected void kickPlayer(String reden) {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.getPlayer().kickPlayer(reden);
            }
        }.runTask(SimpleProject.getInstance());
    }

}
