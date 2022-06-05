package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.question.Question;
import ir.ac.kntu.models.user.Admin;

public class EditCompetitionQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(((Admin) Auth.getCurrentUser()).getOwnedCompetitions());
        Question question = Console.nextQuestion(competition.getQuestions());
        question.edit();
    }
}
