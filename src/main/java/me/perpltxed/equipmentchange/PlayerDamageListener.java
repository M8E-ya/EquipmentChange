package me.perpltxed.equipmentchange;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;


public class PlayerDamageListener implements Listener {
    private Map<Player, Material> helmetMap = new HashMap<>();

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        Material currentHelmet = helmetMap.get(player);
        if (currentHelmet != Material.LEATHER_HELMET) {
            return;
        }
        // Add the code here to send the equipment change packet again
        // and update the helmet Map with the new helmet type
    }
}
