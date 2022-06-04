package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.user.User;

public class RemoveAssistantFromClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());

        System.out.println("Enter the assistant email: ");
        String email = Console.nextLine(Patterns.EMAIL);

        User user = classroom.getAssistants().stream().filter(u -> u.getEmail().equals(email)).toList().get(0);
        if (user == null) {
            throw new IllegalArgumentException("No assistant with this email found.");
        }

        classroom.removeAssistant(user);
    }
}
