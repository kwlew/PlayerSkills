package dev.kwlew.kskills.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MobHitListener implements ListenerComponent {

    private final JavaPlugin plugin;

    public MobHitListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMobHit(EntityDamageByEntityEvent event) {
        if (isPlayer(event.getDamager()) && isHostile(event.getEntity())) {
            Player player = (Player) event.getDamager();

            double damage = event.getDamage();

            player.sendMessage("You hit a: " + event.getEntity().getName() + " for: " + damage + "HP");
        }
    }

    private boolean isHostile(Entity entity) {
        return entity instanceof Monster;
    }

    private boolean isPlayer(Entity entity) {
        return entity instanceof Player;
    }
}
