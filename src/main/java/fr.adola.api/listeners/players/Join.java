package fr.adola.api.listeners.players;

import fr.adola.api.manager.players.GPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.adola.api.API;
import fr.adola.api.manager.game.GameState;
import fr.adola.api.manager.players.GPlayerManager;

import static fr.adola.api.commons.Constant.PREFIX_INFO;
import static org.bukkit.Bukkit.getMaxPlayers;

public class Join implements Listener {

    private API main;

    public Join(API main) {
        this.main = main;
    }

        @EventHandler
        public void onJoin(PlayerJoinEvent event) {

            Player player = event.getPlayer();
            Location lobby = new Location(Bukkit.getWorld("world"), 0.50, 106, 0.50, 90.4f, 1.6f);
            player.teleport(lobby);
            //Player LOBBY event
            player.setCustomName("Player");
            player.setLevel(0);
            player.sendMessage(PREFIX_INFO + "Bienvenu(e) !" + " le jeu commence quand le nombres de " + getMaxPlayers() +
                    " joueurs sera atteint !");

            if (!main.isState(GameState.WAITING)) {
                player.sendMessage("jeud déja start :c");
                player.setGameMode(GameMode.SPECTATOR);
                return;
            }

            if (!main.getPlayers().contains(player)) main.getPlayers().add(player);
            player.setGameMode(GameMode.ADVENTURE);
            event.setJoinMessage(PREFIX_INFO + player.getName() + "§f§l +1 [" + main.getPlayers().size() + "/" + getMaxPlayers() + "]");


            //start la partie quannd le nombres de joueurs suffisant est atteint
            if (main.isState(GameState.WAITING) && main.getPlayers().size() ==2) {
                Bukkit.broadcastMessage("debug size");
                AutoStart start = new AutoStart(main);
                start.runTaskTimer(main, 0, 20);
                main.setState(GameState.STARTING);

            }

            if(main.isState(GameState.STARTING)){
                Bukkit.broadcastMessage("dseubt de la game");
            }


            if (main.isState(GameState.FINISH)) {
                player.getInventory().clear();
                player.teleport(lobby);
            }

        }
}
