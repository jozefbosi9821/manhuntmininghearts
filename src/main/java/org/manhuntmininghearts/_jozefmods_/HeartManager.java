package org.manhuntmininghearts._jozefmods_;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class HeartManager {
    private Map<Player, Integer> hearts = new HashMap<>();

    public void giveHeart(Player player) {
        hearts.put(player, hearts.getOrDefault(player, 0) + 1);
    }

    public void clearHearts() {
        hearts.clear();
    }

    public int getHearts(Player player) {
        return hearts.getOrDefault(player, 0);
    }
}
