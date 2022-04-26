package tpplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import util.FmtMsg;

public class TpCommand implements CommandExecutor {
    private static final boolean SUCCESS = true;

    // On command "abnormal" execution,
    // true is returned to avoid sending
    // its "usage" entry (see plugin.yml).
    private static final boolean MASK = true;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // this command accepts only one argument.
            if (args.length != 1) {
                player.sendMessage(FmtMsg.error("Command requires player username."));
                return MASK;
            }

            String username = args[0];

            // checks if the player is trying to teleport to himself.
            if (username.equals(player.getName())) {
                player.sendMessage(FmtMsg.error("You can't teleport to yourself."));
                return MASK;
            }

            // searches if the other player exist.
            Player playerToTeleportTo = Bukkit.getPlayer(username);
            if (playerToTeleportTo == null) {
                player.sendMessage(FmtMsg.error("Player with username \"" + username + "\" wasn't found."));
                return MASK;
            }

            // tries to teleport to the other player location.
            if (!player.teleport(playerToTeleportTo)) {
                player.sendMessage(FmtMsg.error("Something wrong happened while trying to teleport."));
                return MASK;
            }

            return SUCCESS;
        }
        else {
            // ignore whoever the executor is.
            return MASK;
        }
    }
}
