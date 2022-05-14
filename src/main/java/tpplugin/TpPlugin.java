package tpplugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import tpplugin.commands.TpCommand;

import javax.annotation.Nonnull;
import java.util.logging.Logger;

public final class TpPlugin extends JavaPlugin {
    private final Logger logger;

    public TpPlugin() {
        logger = getLogger();
    }

    public void setCommandExecutor(@Nonnull String name, @Nonnull Class<? extends CommandExecutor> executorClass) {
        PluginCommand command = getCommand(name);

        if (command == null) {
            logger.warning("Command \"" + name + "\" isn't defined");
            return;
        }

        try {
            command.setExecutor(
                    executorClass
                            .getDeclaredConstructor()
                            .newInstance()
            );
        } catch (Exception e) {
            logger.warning("An error occurred while trying to instantiate \"" + executorClass.getCanonicalName() + "\": " + e);
        }
    }

    @Override
    public void onEnable() {
        logger.info("Loading commands...");

        // commands registration.
        setCommandExecutor(TpCommand.NAME, TpCommand.class);
    }

    @Override
    public void onDisable() {
        logger.info("Disabling...");
    }
}
