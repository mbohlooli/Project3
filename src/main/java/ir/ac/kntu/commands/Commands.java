package ir.ac.kntu.commands;

import ir.ac.kntu.commands.auth.*;

import java.util.HashMap;

public class Commands {
    private static HashMap<String, Command> commands = new HashMap<>() {
        {
            put("login", new Login());
            put("logout", new Logout());
            put("register", new Register());
        }
    };

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
