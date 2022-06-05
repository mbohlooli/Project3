package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.competition.Competition;

public class BrowseCompetitions extends SecureCommand {
    @Override
    public void secureExecute() {
        Competitions.getInstance().all().stream().filter(Competition::isVisible).forEach(System.out::println);
    }
}
