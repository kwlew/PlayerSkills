package dev.kwlew.kskills.core.hooks.bstats;

import dev.kwlew.kskills.core.info.Info;
import dev.kwlew.kskills.core.kernel.LifecycleComponent;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class bStatsHook implements LifecycleComponent {

    private final JavaPlugin plugin;
    private Metrics metrics;

    public bStatsHook(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        this.metrics = new Metrics(plugin, Info.BSTATS_ID);
    }
}
