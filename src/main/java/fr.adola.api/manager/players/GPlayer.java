package fr.adola.api.manager.players;

import java.util.UUID;

import org.bukkit.entity.Player;

public class GPlayer {
	
	private Player player;
	private boolean isAlive;
	private boolean isPlaying;
	private boolean isSpec;
	private int kill;
	
	public GPlayer(Player player){
		this.player = player;
		this.isAlive = true;
		this.isPlaying = false;
		this.setSpec(false);
		this.kill = 0;
		GPlayerManager.addPlayer(this); 
	}
	
    public UUID getUniqueId(){
        return player.getUniqueId();
    }

    public String getName(){
        return player.getName();
    }

    public Player getPlayer() {
        return player;
    }
    
    public boolean isAlive() {
    	return isAlive;
    }
    
    public boolean isPlaying() {
    	return isPlaying;
    }

    public int getKill() {
    	return kill;
    }
    
   public void setAlive(boolean alive){
	   this.isAlive = alive;
   }

   public void setPlaying(boolean playing){
	   this.isPlaying = playing;
   }
   
   public void setKill(int kill) {
	   this.kill = kill;
   }

public boolean isSpec() {
	return isSpec;
}

public void setSpec(boolean isSpec) {
	this.isSpec = isSpec;
}
    
}
