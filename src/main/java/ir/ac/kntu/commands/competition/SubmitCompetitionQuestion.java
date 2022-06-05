package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.question.Question;

import java.util.Date;

public class SubmitCompetitionQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Auth.getCurrentUser().getAttendedCompetitions().stream().toList());
        if (competition.getEnd().before(new Date())) {
            throw new IllegalStateException("Time of submission has ended for this competition.");
        }
        Question question = Console.nextQuestion(competition.getQuestions());
        System.out.print("answer: ");
        String answer = Console.nextLine();
        Submission submission = new Submission(answer);
        competition.submitAnswer(question, submission);
    }
}
