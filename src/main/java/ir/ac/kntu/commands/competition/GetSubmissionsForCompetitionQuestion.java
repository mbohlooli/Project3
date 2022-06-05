package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.question.Question;

public class GetSubmissionsForCompetitionQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Auth.getCurrentUser().getAttendedCompetitions().stream().toList());
        Question question = Console.nextQuestion(competition.getQuestions());
        question.getSubmissions(Auth.getCurrentUser()).getSubmissions().forEach(System.out::println);
    }
}
