package yschuurmans.AxolotlSaver.EventListeners;

import yschuurmans.AxolotlSaver.AxolotlSaver;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.logging.Logger;

public class AxolotlDamageHandler implements Listener {

    private final Logger logger;
    private final AxolotlSaver plugin;

    public AxolotlDamageHandler(AxolotlSaver plugin) {
        this.plugin = plugin;
        logger = plugin.getLogger();
    }

    @EventHandler
    final void onEntityDamageEvent(EntityDamageEvent event) {
        var entity = event.getEntity();
        if (!entity.getType().equals(EntityType.AXOLOTL)) {
            return;
        }

        if (!event.isCancelled()) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK) || 
                event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) ||
                event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK)) {
                return;
            }
            if (entity.getCustomName() == null) {
                return;
            }
            //logger.info("Axolotl suffocation prevented");
            event.setCancelled(true);
        }
    }
}
