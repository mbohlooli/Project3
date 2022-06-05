package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.competition.Competition;

public class SearchCompetitionByTitle extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.print("title: ");
        String title = Console.nextLine();
        Competitions.getInstance().search(c -> c.getTitle().equals(title)).forEach(System.out::println);
    }
}
