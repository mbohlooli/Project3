package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.user.User;
import ir.ac.kntu.models.question.Question;

public class ScoreSubmissionsForQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Question question = Console.nextQuestion(QuestionBank.getInstance().all());
        if (!question.getOwner().equals(Auth.getCurrentUser())) {
            throw new IllegalStateException("Access denied.");
        }
        User user = Console.nextUser(question.getUsers());
        Submission submission = question.getSubmissions(user).getFinalSubmission();
        System.out.println(submission);
        System.out.println("Enter the score: ");
        int score = Console.nextInt();
        submission.setScore(score);
    }
}
