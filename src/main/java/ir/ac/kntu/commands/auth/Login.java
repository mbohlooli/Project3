package ir.ac.kntu.commands.auth;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;

public class Login implements Command {
    @Override
    public void execute() {
        System.out.print("username: ");
        String username = Console.nextLine();
        System.out.print("password: ");
        String password = Console.nextLine();

        Auth.login(username, password);
    }
}
