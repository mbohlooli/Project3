package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.question.Question;

import java.util.Date;
import java.util.List;

public class GetEndedCompetitionQuestions extends SecureCommand {
    @Override
    public void secureExecute() {
        List<Competition> endedCompetitions = Competitions.getInstance().all().stream().filter(c -> c.getEnd().before(new Date())).toList();
        Competition competition = Console.nextCompetition(endedCompetitions);
        Question question = Console.nextQuestion(competition.getQuestions());
        System.out.println(question);
    }
}
