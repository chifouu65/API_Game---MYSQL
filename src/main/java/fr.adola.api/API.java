package fr.adola.api;

import fr.adola.api.listeners.players.Join;
import fr.adola.api.manager.CommandsManager;
import fr.adola.api.manager.database.SqlManager;
import fr.adola.api.manager.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.adola.api.manager.event.EventManager;
import fr.adola.api.manager.game.GameManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class API extends JavaPlugin {

    private EventManager eventManager;
    public List<Player> players = new ArrayList<>();
    public List<Location> gamespawn = new ArrayList<>();
    private GameManager gameManager;
    public static API INSTANCE;
    private SqlManager sqlManager;
    private Join join;
    private GameState state;


    @Override
    public void onEnable() {
        INSTANCE = this;
        try {
            sqlManager = new SqlManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CommandsManager.setupCommandsSystem(this);

        this.gameManager = new GameManager(this);
        this.eventManager = new EventManager(this);
        this.eventManager = new TaggedEvent(this);
        this.join = new Join(this);

        Bukkit.getWorlds().forEach(world -> {
            world.setGameRuleValue("commandBlockOutput", "false");
            world.setGameRuleValue("announceAdvancements", "false");
        });

        System.out.println("Narcisse is ENABLE");

    }

    @Override
    public void onDisable() {
        this.sqlManager.close();
        System.out.println("Narcisse is DISABLE");

    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public SqlManager getSqlManager() {
        return sqlManager;
    }

    public static API getINSTANCE() {
        return INSTANCE;
    }

    public void getSqlManager(SqlManager sqlManager) {
        this.sqlManager = sqlManager;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setState(GameState state) {
        this.state = state;
    }
    public boolean isState(GameState state) {
        return this.state == state;
    }
    public List<Location> getGameSpawn() {
        return gamespawn;
    }
}

