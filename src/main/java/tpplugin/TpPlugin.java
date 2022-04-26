package tpplugin;

import org.bukkit.plugin.java.JavaPlugin;
import tpplugin.commands.TpCommand;

import java.util.logging.Logger;

public final class TpPlugin extends JavaPlugin {
    private final Logger logger;

    public TpPlugin() {
        logger = getLogger();
    }

    @Override
    public void onEnable() {
        logger.info("Loading commands...");

        // commands registration.
        getCommand("tp").setExecutor(new TpCommand());
    }

    @Override
    public void onDisable() {
        logger.info("Disabling...");
    }
}
