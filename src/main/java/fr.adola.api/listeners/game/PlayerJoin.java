package fr.adola.api.listeners.game;

import fr.chifouu.svplugin.SvPlugin;
import fr.chifouu.svplugin.task.AutoStart;
import fr.chifouu.svplugin.task.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private SvPlugin main;

    public PlayerJoin(SvPlugin main){
        this.main = main;
    }


    @EventHandler
    public void onJoinHUB(PlayerJoinEvent event){

        Player player = event.getPlayer();
        Location spawn = new Location(Bukkit.getWorld("world"), 0.50, 104, 0.50);
        player.teleport(spawn);
        player.getInventory().clear();
        player.setInvisible(false);
        player.setInvulnerable(true);
        player.setHealth(20);
        player.updateInventory();
        event.setJoinMessage(player.getName() + " §lhave join the Game!");

        if(!main.isGameState(GameState.WATTING)){
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(" The game have started ! sorry. . .");
            return;
        }

        if(!main.getPlayers().contains(player)) main.getPlayers().add(player);
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage("MSG JOIN");

        if(main.isGameState(GameState.WATTING) && main.getPlayers().size() >= 1){
            AutoStart start = new AutoStart(main);
            start.runTaskTimer(main, 0,20L);
            main.setGameState(GameState.STARTING1);
        }

    }
    @EventHandler
    public void onLeaveHUB(PlayerJoinEvent event){
    }



    @EventHandler
    public void FoodLvl(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }


}
