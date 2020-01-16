package com.djorr.simpleproject.command;

import com.djorr.simpleproject.SimpleProject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class PluginCommand implements CommandExecutor {

    public String name;
    public boolean op;
    public String[] args;
    public boolean hasSubCommands;
    public CommandSender sender;

    public PluginCommand(String name, boolean op) {
        this.name = name;
        this.op = op;
        this.hasSubCommands = false;

        SimpleProject.getInstance().getCommand(name).setExecutor(this);
    }

    public abstract void execute();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.op) {
            if (!sender.isOp())
                return false;
        }

        if (label.equalsIgnoreCase(name)) {
            if (args.length > 0) {
                this.args = args;
                this.hasSubCommands = true;
            }

            this.sender = sender;

            this.execute();

            resetAll();
        }

        return false;
    }

    private void resetAll() {
        this.args = null;
        this.sender = null;
        this.hasSubCommands = false;
    }
}
