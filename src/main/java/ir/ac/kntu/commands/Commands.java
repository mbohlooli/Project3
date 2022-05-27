package ir.ac.kntu.commands;

import ir.ac.kntu.commands.auth.Logout;

import java.util.HashMap;

public class Commands {
    private static HashMap<String, Command> commands = new HashMap<>() {
        {
            put("logout", new Logout());
        }
    };

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
