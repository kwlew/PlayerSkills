package dev.kwlew.kskills.listeners;
// btw i created a tailscale network
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MobHitListener implements Listener {

    @EventHandler
    public void onMobHit(EntityDamageByEntityEvent event) {
        if (isHostile(event.getDamager()) && isPlayer(event.getEntity())) {
            Player player = (Player) event.getEntity();

            player.sendMessage("You got damaged by: " + event.getDamager().getName());
        }
    }

    private boolean isHostile(Entity entity) {
        return entity instanceof Monster;
    }

    private boolean isPlayer(Entity entity) {
        return entity instanceof Player;
    }
}
