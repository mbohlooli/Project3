package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.question.Question;

public class SubmitAssignmentQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getEnrolledClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);
        Question question = Console.nextQuestion(assignment.getQuestions());

        System.out.print("answer: ");
        String answer = Console.nextLine();
        Submission submission = new Submission(answer);
        assignment.submitAnswer(question, submission);
    }
}
