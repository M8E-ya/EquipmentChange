package me.perpltxed.equipmentchange;

import org.bukkit.plugin.java.JavaPlugin;

public class EquipmentChange extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic, we had nothing special running so we I left it empty :D
    }
}
