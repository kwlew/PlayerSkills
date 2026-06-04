package dev.kwlew.kskills.core.hooks.papi;

import dev.kwlew.kskills.core.kernel.LifecycleComponent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlaceholderAPIHook implements LifecycleComponent {

    private final JavaPlugin plugin;

    public PlaceholderAPIHook(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        if (plugin.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderAPI().register();
        }
    }
}
