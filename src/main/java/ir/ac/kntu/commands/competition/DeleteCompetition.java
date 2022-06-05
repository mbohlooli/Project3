package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.user.Admin;

public class DeleteCompetition extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(((Admin) Auth.getCurrentUser()).getOwnedCompetitions());
        System.out.print("Are you sure (y/n)?");
        boolean sure = Console.nextBoolean();
        if (sure) {
            Competitions.getInstance().remove(competition);
            ((Admin) Auth.getCurrentUser()).removeOwnedCompetition(competition);
            //TODO: make an enrolled competition feild in user class and remove them too
        }
    }
}
