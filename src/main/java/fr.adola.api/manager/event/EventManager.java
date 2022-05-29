package fr.adola.api.manager.event;

import fr.adola.api.listeners.game.GameListener;
import fr.adola.api.listeners.game.LobbyListeners;
import fr.adola.api.listeners.players.Join;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import fr.adola.api.API;


public class EventManager {

    private final API api;
    private PluginManager pluginManager;

    public EventManager(API api) {
        this.api = api;
        this.pluginManager = Bukkit.getPluginManager();
        registerEvents();
    }

    private void registerEvents() {
        pluginManager.registerEvents(new Join(api), api);
        pluginManager.registerEvents(new LobbyListeners(api), api);
        pluginManager.registerEvents(new GameListener(api), api);


    }

    public void addNewEveListener(Listener listener) {
        pluginManager.registerEvents(listener, api);
    }


}
