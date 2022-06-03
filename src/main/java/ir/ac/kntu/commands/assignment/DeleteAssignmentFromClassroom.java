package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;

public class DeleteAssignmentFromClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);
        System.out.print("Are you sure (y/n)? ");
        boolean sure = Console.nextBoolean();
        if (sure) {
            classroom.deleteAssignment(assignment);
        }
    }
}
