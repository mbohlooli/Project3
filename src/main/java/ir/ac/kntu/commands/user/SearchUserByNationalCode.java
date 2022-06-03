package ir.ac.kntu.commands.user;

import ir.ac.kntu.commands.Command;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.data.Users;

public class SearchUserByNationalCode implements Command {
    @Override
    public void execute() {
        System.out.println("Enter the national code of user: ");
        String nationalCode = Console.nextLine(Patterns.NATIONAL_CODE);
        Users.getInstance().search(u -> u.getNationalCode().equals(nationalCode)).forEach(System.out::println);
    }
}
