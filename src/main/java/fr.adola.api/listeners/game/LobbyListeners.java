package fr.adola.api.listeners.game;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.adola.api.API;
import fr.adola.api.manager.game.GameState;

public class LobbyListeners implements Listener {

    private API main;

    public LobbyListeners(API main) {
        this.main = main;
    }

    @EventHandler
    public void onDamageWatting(EntityDamageEvent event) {
        if (main.getGameManager().getGameState().equals(GameState.WAITING)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamageOverPvp(EntityDamageEvent event) {
        if (main.getGameManager().getGameState().equals(GameState.STARTING)) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockPlaceLobby(BlockBreakEvent event) {
        if (main.getGameManager().getGameState().equals(GameState.WAITING)) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onBreakBlockLobby(BlockPlaceEvent event) {
        if (main.getGameManager().getGameState().equals(GameState.WAITING)) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent event) {
        if (main.getGameManager().getGameState().equals(GameState.WAITING)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {

        if (main.getGameManager().getGameState().equals(GameState.WAITING)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void foodLevelChangeModeration(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();
        if (main.getGameManager().getGameState().equals(GameState.WAITING)) {
            e.setCancelled(true);
            p.setFoodLevel(25);
            p.setSaturation(20);
        }

    }

}
