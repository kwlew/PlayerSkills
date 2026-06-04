package dev.kwlew.kskills.listeners;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockListener implements ListenerComponent {

    private final JavaPlugin plugin;

    public BlockListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        switch (event.getBlock().getType()) {
            case OAK_LOG -> {
                brokeBlock(event);
            }
            default -> {
                return;
            }
        }
    }

    private void brokeBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();

        player.sendMessage(NamedTextColor.RED + "You broke a: " + event.getBlock().getType());
    }
}
