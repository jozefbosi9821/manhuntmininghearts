package org.manhuntmininghearts._jozefmods_;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ManhuntMiningHearts extends JavaPlugin {
    private TeamManager teamManager;
    private HeartManager heartManager; // Add this field

    @Override
    public void onEnable() {
        // Initialize managers
        teamManager = new TeamManager();
        heartManager = new HeartManager(); // Initialize HeartManager

        // Register event listeners
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);

        // Register commands
        getCommand("addhunter").setExecutor(new AddHunterCommand(this));
        getCommand("removehunter").setExecutor(new RemoveHunterCommand(this));
        getCommand("addspeedrunner").setExecutor(new AddSpeedrunnerCommand(this));
        getCommand("removespeedrunner").setExecutor(new RemoveSpeedrunnerCommand(this));
        getCommand("manhuntteams").setExecutor(new ReloadTeamsCommand(this));

        // Register PlaceholderAPI expansion
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new TeamPlaceholder(this).register();
        }


    }

    @Override
    public void onDisable() {

    }

    // Add this method to retrieve the HeartManager
    public HeartManager getHeartManager() {
        return heartManager;
    }

    // Add this method to retrieve the TeamManager
    public TeamManager getTeamManager() {
        return teamManager;
    }
}
