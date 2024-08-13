package yschuurmans.AxolotlSaver;

import yschuurmans.AxolotlSaver.EventListeners.AxolotlDamageHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class AxolotlSaver extends JavaPlugin {

    public static AxolotlSaver Instance;

    @Override
    public void onEnable() {
        Instance = this;       
        this.getServer().getPluginManager().registerEvents(new AxolotlDamageHandler(this), this);
    }

    @Override
    public void onDisable() {
    }
}
