package com.djorr.simpleproject.command.commands;

import com.djorr.simpleproject.command.PluginCommand;
import com.djorr.simpleproject.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.omg.CORBA.Environment;

public class CommandSpawn extends PluginCommand {

    public CommandSpawn(String name, boolean op) { super(name, op); }

    /** Even simpel een spawn locatie pakken, kon dit ook via een config doen maar eventjes hardcoded dit**/
    private Location spawn = Bukkit.getWorld("naam").getSpawnLocation();

    @Override
    public void execute() {

        /** Checken of het wel een speler is **/

        if (this.sender instanceof Player) {
            Player player = (Player) this.sender;

            if (this.args == null) {

                /** Als de speler de permissie niet heeft krijgt die een melding terug **/

                if (!(player.hasPermission("simple.spawn"))) {
                    player.sendMessage(Message.prefix + Message.defaultColor + " Je hebt hier geen permissie voor!");
                    return;
                }

                /** Als spawn null is dan krijg je een melding, werkt alleen als config gebruikt wordt **/

                if (spawn == null) {
                    player.sendMessage(Message.prefix + Message.defaultColor + " Spawn is niet geplaatst.");
                }

                this.sender.sendMessage(Message.prefix + "Je bent nu naar de spawn geteleporteerd!");
                ((Player) this.sender).teleport(spawn);
            }
        }
    }
}
