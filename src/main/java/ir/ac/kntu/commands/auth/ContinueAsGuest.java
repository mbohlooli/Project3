package ir.ac.kntu.commands.auth;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.commands.Commands;

public class ContinueAsGuest implements Command {
    @Override
    public void execute() {
        Commands.loadGuestCommands();
    }
}
