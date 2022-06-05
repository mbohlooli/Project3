package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.data.Groups;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.competition.SpecialCompetition;
import ir.ac.kntu.models.user.Group;

public class AttendCompetition extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Competitions.getInstance().all().stream().filter(Competition::isVisible).toList());
        if (competition instanceof SpecialCompetition) {
            Group group = Console.nextGroup(Groups.getInstance().all().stream().filter(g -> g.contains(Auth.getCurrentUser())).toList());
            group.attendCompetition(competition);
            return;
        }
        Auth.getCurrentUser().attendCompetition(competition);
    }
}
