package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.user.User;


public class AddStudentToClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());

        System.out.println("Enter the student email: ");
        String email = Console.nextLine(Patterns.EMAIL);
        User user = Users.getInstance().get(u -> u.getEmail().equals(email));
        if (user == null) {
            throw new IllegalArgumentException("No user with this email found.");
        }

        user.enrollClassroom(classroom);
    }
}
