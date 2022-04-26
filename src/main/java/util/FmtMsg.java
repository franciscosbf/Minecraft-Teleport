package util;

import org.bukkit.ChatColor;

public final class FmtMsg {
    private static final String ERROR = ChatColor.RED + "[ERROR] " + ChatColor.WHITE;

    public static String error(String msg) {
        return ERROR + msg;
    }
}
