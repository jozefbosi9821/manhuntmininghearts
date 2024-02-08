package org.manhuntmininghearts._jozefmods_;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class TeamManager {
    private Set<Player> hunters = new HashSet<>();
    private Set<Player> speedrunners = new HashSet<>();

    public boolean hasLeaderPermission(Player player) {
        return player.hasPermission("manhunt.leader");
    }

    public boolean isHunter(Player player) {
        return hunters.contains(player);
    }

    public boolean isSpeedrunner(Player player) {
        return speedrunners.contains(player);
    }

    public void addHunter(Player player) {
        hunters.add(player);
    }

    public void removeHunter(Player player) {
        hunters.remove(player);
    }

    public void addSpeedrunner(Player player) {
        speedrunners.add(player);
    }

    public void removeSpeedrunner(Player player) {
        speedrunners.remove(player);
    }

    public void clearTeams() {
        hunters.clear();
        speedrunners.clear();
    }
}
