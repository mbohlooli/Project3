package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;

import java.util.ArrayList;
import java.util.List;

public class GetScoreTableOfAssignment extends SecureCommand {
    @Override
    public void secureExecute() {
        List<Classroom> ownedClassrooms = new ArrayList<>(Auth.getCurrentUser().getOwnedClassrooms());
        List<Classroom> enrolledClassrooms = new ArrayList<>(Auth.getCurrentUser().getEnrolledClassrooms());
        List<Classroom> allClassrooms = new ArrayList<>();
        allClassrooms.addAll(ownedClassrooms);
        allClassrooms.addAll(enrolledClassrooms);
        Classroom classroom = Console.nextClassroom(allClassrooms);
        Assignment assignment = Console.nextAssignment(classroom);
        if (!Auth.getCurrentUser().isOwner(classroom) && !assignment.isScoreTableVisible()) {
            throw new IllegalStateException("Access denied.");
        }
        assignment.displayScoreTable();
    }
}
