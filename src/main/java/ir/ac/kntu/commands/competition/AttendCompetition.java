package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.competition.Competition;

public class AttendCompetition extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Competitions.getInstance().all().stream().filter(Competition::isVisible).toList());
        Auth.getCurrentUser().attendCompetition(competition);
    }
}
