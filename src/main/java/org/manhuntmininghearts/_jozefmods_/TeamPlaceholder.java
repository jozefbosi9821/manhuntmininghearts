package org.manhuntmininghearts._jozefmods_;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TeamPlaceholder extends PlaceholderExpansion {
    private final ManhuntMiningHearts plugin;

    public TeamPlaceholder(ManhuntMiningHearts plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "manhunt";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Jozef Gaming";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }


    public String onRequest(Player player, @NotNull String identifier) {
        if (identifier.equals("team")) {
            TeamManager teamManager = plugin.getTeamManager();
            if (teamManager.isHunter(player)) {
                return "Hunter";
            } else if (teamManager.isSpeedrunner(player)) {
                return "Speedrunner";
            } else {
                return "No Team";
            }
        }
        return null;
    }
}
