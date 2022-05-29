package fr.adola.api.commands;

import fr.adola.api.manager.players.GPlayerManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.adola.api.API;
import fr.adola.api.commands.framework.Command;
import fr.adola.api.commands.framework.CommandArgs;
import fr.adola.api.manager.game.GameState;


public class StartCommand {

    private API main;

    public StartCommand(API main){
        this.main = main;
    }

    @Command(name = "start", aliases = {"start"})
    public void onStart(CommandArgs args) {
        CommandSender sender = args.getSender();
        if ((sender instanceof Player)) {

            if (main.getGameManager().getGameState().equals(GameState.WAITING)) {

            }
        }
    }
}


