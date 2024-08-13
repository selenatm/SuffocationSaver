package yschuurmans.AxolotlSaver.EventListeners;

import yschuurmans.AxolotlSaver.AxolotlSaver;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class AxolotlDamageHandler implements Listener {

    public AxolotlDamageHandler(AxolotlSaver plugin) { }

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
            //System.out.println("Axolotl suffocation prevented");
            event.setCancelled(true);
        }
    }
}