package ir.ac.kntu.commands.user;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

public class PromoteUserToAdmin extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.println("Enter the user email: ");
        String email = Console.nextLine(Patterns.EMAIL);
        User user = Users.getInstance().get(u -> u.getEmail().equals(email));
        if (user == null) {
            throw new IllegalArgumentException("No user with this email found.");
        }
        int index = Users.getInstance().all().indexOf(user);
        user = new Admin(user.getName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getNationalCode(), user.getPhone());
        Users.getInstance().update(index, user);
    }
}
