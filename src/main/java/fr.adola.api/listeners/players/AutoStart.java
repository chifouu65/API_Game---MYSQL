package fr.adola.api.listeners.players;

import fr.adola.api.API;
import fr.adola.api.manager.game.GameState;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static fr.adola.api.commons.Constant.PREFIX_INFO;

public class AutoStart extends BukkitRunnable {

    private final API main;
    private int timer = 15;

    public AutoStart(API main) {
        this.main = main;
    }

    @Override
    public void run() {

        for (Player pls : main.getPlayers()) {
            pls.setLevel(timer);
        }

        if (timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
            Bukkit.broadcastMessage(PREFIX_INFO + "Lancement du jeu dans " +
                    ChatColor.GREEN + timer + ChatColor.YELLOW + "s");
        }
        if (timer == 0) {
            Bukkit.broadcastMessage(PREFIX_INFO + "Lancement du §f§ljeu");
            main.setState(GameState.PLAYING);// lance le mode de jeux en playing

            for (int i = 0; i < main.getPlayers().size(); i++) {
                Player player = main.getPlayers().get(i);//item lobby
                Location spawn = main.getGameSpawn().get(i);
                player.teleport(spawn);
                player.setGameMode(GameMode.SURVIVAL);
                player.setItemInHand(new ItemStack(Material.DIAMOND_SWORD, 1));
                player.setHealth(20);
                player.setSaturation(20);
            }
            cancel();
        }
        timer--;
    }

}
