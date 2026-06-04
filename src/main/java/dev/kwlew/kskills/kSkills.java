package dev.kwlew.kskills;

import dev.kwlew.kskills.core.kernel.Bootstrap;
import org.bukkit.plugin.java.JavaPlugin;

public final class kSkills extends JavaPlugin {

    private Bootstrap bootstrap;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        bootstrap = new Bootstrap(this);
        bootstrap.init();
    }

    @Override
    public void onDisable() {
         if (bootstrap != null) {
             bootstrap.shutdown();
         }
    }
}
