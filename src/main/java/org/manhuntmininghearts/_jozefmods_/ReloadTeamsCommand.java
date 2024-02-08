package org.manhuntmininghearts._jozefmods_;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadTeamsCommand implements CommandExecutor {
    private final ManhuntMiningHearts plugin;

    public ReloadTeamsCommand(ManhuntMiningHearts plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("manhunt.leader")) {
            sender.sendMessage("You don't have permission to use this command!");
            return true;
        }

        TeamManager teamManager = plugin.getTeamManager();
        teamManager.clearTeams(); // Clear all teams

        // Optionally, you can clear players' hearts or any other associated data here
        plugin.getHeartManager().clearHearts(); // Example: Clear all hearts

        sender.sendMessage("Teams reloaded successfully!");

        return true;
    }
}
