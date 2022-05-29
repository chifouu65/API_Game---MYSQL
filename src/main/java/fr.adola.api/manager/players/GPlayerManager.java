package fr.adola.api.manager.players;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.adola.api.API;

public class GPlayerManager {

    private static final List<GPlayer> GPLAYER = new ArrayList<>();

    public static void addPlayer(GPlayer gplayer) {
        if (!GPLAYER.contains(gplayer)) {
            GPLAYER.add(gplayer);
        }

    }

    public static GPlayer getGPlayer(UUID uuid) {
        GPlayer gPlayer = null;
        for (GPlayer gPlayers : GPLAYER) {
            if (gPlayers.getUniqueId().equals(uuid)){
                gPlayer = gPlayers;
            }
        }
        return gPlayer;
    }


    public static GPlayer getGPlayer(String name) {
        return GPLAYER.stream()
                .filter(player -> player.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public static GPlayer getGPlayer(Player player) {
        return getGPlayer(player.getUniqueId());
    }


    public static boolean haveGPlayer(UUID uuid) {
        return GPLAYER.stream().anyMatch(player -> player.getUniqueId().equals(uuid));
    }

    public static boolean haveGPlayer(String name) {
        return GPLAYER.stream()
                .anyMatch(player -> player.getName().equals(name));
    }

    public static boolean haveGPlayer(Player player) {
        return haveGPlayer(player.getUniqueId());
    }

    public static int getConnectedPlayer() {
        int i = 0;
        for (Player players : Bukkit.getOnlinePlayers()) {
            GPlayer gplayer = getGPlayer(players.getUniqueId());
            if (gplayer.isAlive() && !gplayer.isSpec()) {
                i++;
            }
        }
        return i;
    }


}
