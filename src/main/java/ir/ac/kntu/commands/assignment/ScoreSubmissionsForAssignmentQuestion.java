package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.question.Question;

public class ScoreSubmissionsForAssignmentQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);
        Question question = Console.nextQuestion(assignment.getQuestions());
        User user = Console.nextUser(question.getUsers());
        Submission submission = question.getSubmissions(user).getFinalSubmission();
        System.out.println(submission);
        System.out.println("Enter the score: ");
        int score = Console.nextInt();
        submission.setScore(score);
    }
}
