package ir.ac.kntu.commands.auth;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.core.Auth;

public class Logout implements Command {
    @Override
    public void execute() {
        Auth.logout();
    }
}
