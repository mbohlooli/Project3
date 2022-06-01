package ir.ac.kntu.commands.user;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Users;

public class SearchUserByEmail implements Command {
    @Override
    public void execute() {
        System.out.println("Enter the email of user: ");
        String email = Console.nextLine("^.*@[a-zA-Z]+\\.[a-zA-Z]+$");
        Users.getInstance().search(u -> u.getEmail().equals(email)).forEach(System.out::println);
    }
}
