package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Classroom;

import java.util.ArrayList;
import java.util.List;

public class GetAssignmentsOfClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        List<Classroom> classrooms = new ArrayList<>(Auth.getCurrentUser().getOwnedClassrooms());
        classrooms.addAll(Auth.getCurrentUser().getEnrolledClassrooms());
        Classroom classroom = Console.nextClassroom(classrooms);

        classroom.getAssignments().forEach(System.out::println);
    }
}
