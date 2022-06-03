package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.question.Question;

public class EditAssignmentQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);
        Question question = Console.nextQuestion(assignment.getQuestions());

        if (!question.getOwner().equals(Auth.getCurrentUser())) {
            throw new IllegalStateException("Access denied. Please contact the owner.");
        }

        question.edit();
    }
}
