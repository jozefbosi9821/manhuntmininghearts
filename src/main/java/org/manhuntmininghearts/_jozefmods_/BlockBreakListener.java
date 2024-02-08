package org.manhuntmininghearts._jozefmods_;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    private final ManhuntMiningHearts plugin;

    public BlockBreakListener(ManhuntMiningHearts plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;

        TeamManager teamManager = plugin.getTeamManager();
        HeartManager heartManager = plugin.getHeartManager();

        if (teamManager.isHunter(player)) {
            for (Player nearbyPlayer : player.getWorld().getPlayers()) {
                if (teamManager.isSpeedrunner(nearbyPlayer)) {
                    heartManager.giveHeart(nearbyPlayer);
                }
            }
        }
    }
}
