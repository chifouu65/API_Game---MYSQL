package fr.adola.api.manager;

import fr.adola.api.API;
import fr.adola.api.commands.StartCommand;
import fr.adola.api.commands.framework.CommandFramework;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsManager {

    private static CommandFramework framework;

    public static void setupCommandsSystem(API plugin) {
        framework = new CommandFramework(plugin);

        registerNewCommand(new StartCommand(plugin));
    }

    public static void registerNewCommand(Object object) {
        framework.registerCommands(object);
    }

}