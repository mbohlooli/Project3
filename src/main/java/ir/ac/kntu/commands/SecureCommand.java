package ir.ac.kntu.commands;

import ir.ac.kntu.core.Auth;

public abstract class SecureCommand implements Command {
    @Override
    public void execute() {
        //TODO: make a separate interface for having multiple validations
        if (!Auth.isLoggedIn()) {
            throw new IllegalStateException("You must login to use this command.");
        }
        secureExecute();
    }

    public abstract void secureExecute();
}
