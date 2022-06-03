package ir.ac.kntu.commands.auth;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.models.User;

public class Register implements Command {
    @Override
    public void execute() {
        System.out.print("name: ");
        String name = Console.nextLine();
        System.out.print("username: ");
        String username = Console.nextLine();
        System.out.print("password: ");
        String password = Console.nextLine();
        System.out.print("email: ");
        String email = Console.nextLine(Patterns.EMAIL);
        System.out.print("national code: ");
        String nationalCode = Console.nextLine(Patterns.NATIONAL_CODE);
        System.out.print("phone number: ");
        String phone = Console.nextLine(Patterns.PHONE_NUMBER);

        User user = new User(name, username, password, email, nationalCode, phone);
        Auth.register(user);
    }
}
