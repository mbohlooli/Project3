package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.question.Question;
import ir.ac.kntu.models.user.User;

public class ScoreSubmissionForCompetitionQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Auth.getCurrentAdmin().getOwnedCompetitions());
        Question question = Console.nextQuestion(competition.getQuestions());
        User user = Console.nextUser(question.getUsers());
        Submission submission = question.getSubmissions(user).getFinalSubmission();
        System.out.println(submission);
        System.out.println("Enter the score: ");
        int score = Console.nextInt();
        submission.setScore(score);
    }
}
