package ir.ac.kntu.commands.auth;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.User;

public class Register implements Command {
    @Override
    public void execute() {
        //TODO: move sout to console
        System.out.print("name: ");
        String name = Console.nextLine();
        System.out.print("username: ");
        String username = Console.nextLine();
        System.out.print("password: ");
        String password = Console.nextLine();
        //TODO: move the patterns to a constant static class
        System.out.print("email: ");
        String email = Console.nextLine("^.*@[a-zA-Z]+\\.[a-zA-Z]+$");
        System.out.print("national code: ");
        String nationalCode = Console.nextLine("^\\d{10}$");
        System.out.print("phone number: ");
        String phone = Console.nextLine("^09\\d{9}$");

        User user = new User(name, username, password, email, nationalCode, phone);
        Auth.register(user);
    }
}
