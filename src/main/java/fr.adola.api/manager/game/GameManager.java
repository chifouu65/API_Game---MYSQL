package fr.adola.api.manager.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import fr.adola.api.API;
import org.bukkit.entity.Player;

public class GameManager {

	private final API api;
	private int slot;
	private GameState gameState;
	
	private List<Location> locationSpawn;
	
	public GameManager(API api){
		this.api = api;
		this.gameState = GameState.WAITING;
		this.slot = 2;
		this.locationSpawn = new ArrayList<>();
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public API getApi() {
		return api;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public List<Location> getLocationSpawn(Player player) {
		return locationSpawn;
	}


	Location hub = new Location(Bukkit.getWorld("world"), 0.50, 100, 0, 50, 0);
	
	
	
}
