package me.perpltxed.equipmentchange;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {
    private EquipmentChange plugin;
    public PlayerJoinListener(EquipmentChange plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bukkit.getLogger().info("onPlayerJoin method called");
        final Player player = event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.getType() == Material.DIAMOND_HELMET) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, () -> {
                for (Player observer : Bukkit.getOnlinePlayers()) {
                    if (isObserving(observer, player)) {
                        observer.sendEquipmentChange(player, EquipmentSlot.HEAD, new ItemStack(Material.LEATHER_HELMET));
                        Bukkit.getLogger().info("Packet sent to observer " + observer.getName());
                    }
                }
            }, 20);
        }
    }

    private boolean isObserving(Player observer, Player player) {
        // Check if the observer player is observing the player, you can use observer.canSee(player) or observer.getLocation().distanceSquared(player.getLocation())
        final double MAX_DISTANCE = 100; // Change this to the maximum distance you want to check
        return observer.getLocation().distanceSquared(player.getLocation()) <= MAX_DISTANCE * MAX_DISTANCE;
    }
}
