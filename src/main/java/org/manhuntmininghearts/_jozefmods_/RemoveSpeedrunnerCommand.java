package org.manhuntmininghearts._jozefmods_;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveSpeedrunnerCommand implements CommandExecutor {
    private final ManhuntMiningHearts plugin;

    public RemoveSpeedrunnerCommand(ManhuntMiningHearts plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        TeamManager teamManager = plugin.getTeamManager();

        if (!teamManager.hasLeaderPermission(player)) {
            player.sendMessage("You don't have permission to use this command!");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("Usage: /removespeedrunner <player>");
            return true;
        }

        Player targetPlayer = plugin.getServer().getPlayer(args[0]);
        if (targetPlayer == null || !targetPlayer.isOnline()) {
            player.sendMessage("Player not found or not online!");
            return true;
        }

        teamManager.removeSpeedrunner(targetPlayer);
        player.sendMessage(targetPlayer.getName() + " has been removed from the Speedrunner team.");

        return true;
    }
}
