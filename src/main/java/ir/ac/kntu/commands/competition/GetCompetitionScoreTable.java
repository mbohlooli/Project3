package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.user.Admin;

import java.util.ArrayList;
import java.util.List;

public class GetCompetitionScoreTable extends SecureCommand {
    @Override
    public void secureExecute() {
        List<Competition> competitions = new ArrayList<>();
        if (Auth.getCurrentUser() instanceof Admin) {
            competitions = Auth.getCurrentUser().getAttendedCompetitions().stream().toList();
        }
        Competition competition = Console.nextCompetition(competitions);
        competition.displayScoreTable();
    }
}
