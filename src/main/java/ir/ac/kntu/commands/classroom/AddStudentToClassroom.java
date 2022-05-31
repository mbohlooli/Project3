package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AddStudentToClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        List<Classroom> classrooms = Auth.getCurrentUser().getOwnedClassrooms().stream().toList();

        AtomicInteger counter = new AtomicInteger(1);
        classrooms.forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the classroom index you want to add student to: ");
        int index = Console.nextInt() - 1;
        Classroom classroom = classrooms.get(index);

        System.out.println("Enter the student email: ");
        String email = Console.nextLine("^.*@[a-zA-Z]+\\.[a-zA-Z]+$");
        User user = Users.getInstance().get(u -> u.getEmail().equals(email));
        if (user == null) {
            throw new IllegalArgumentException("No user with this email found.");
        }

        user.enrollClassroom(classroom);
    }
}