package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.models.Classroom;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EnrollClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        ArrayList<Classroom> classrooms = Classrooms.getInstance().all();

        AtomicInteger counter = new AtomicInteger(1);
        classrooms.forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the classroom index you want to enroll: ");
        int index = Console.nextInt() - 1;
        Classroom classroom = classrooms.get(index);

        if (classroom.getPassword() != null) {
            System.out.println("Enter the classroom password: ");
            String password = Console.nextLine();
            if (!classroom.getPassword().equals(password)) {
                throw new IllegalArgumentException("Invalid password.");
            }
        }

        Auth.getCurrentUser().enrollClassroom(classroom);
    }
}
