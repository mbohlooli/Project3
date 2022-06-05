package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.competition.PrivateCompetition;
import ir.ac.kntu.models.competition.RegularCompetition;
import ir.ac.kntu.models.competition.SpecialCompetition;
import ir.ac.kntu.models.user.Admin;

import java.util.Date;

public class CreateCompetition extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.println("Title: ");
        String title = Console.nextLine();
        System.out.println("Start: ");
        Date start = Console.nextDate();
        System.out.println("End: ");
        Date end = Console.nextDate();

        if (start.after(end)) {
            throw new IllegalArgumentException("End cannot be before start.");
        }

        System.out.println("1) Special Competition  2) Private Competition  3) Regular Competition");
        int type = Console.nextInt();
        Competition competition;
        switch (type) {
            case 1 -> competition = new SpecialCompetition(title, start, end);
            case 2 -> competition = new PrivateCompetition(title, start, end);
            case 3 -> competition = new RegularCompetition(title, start, end);
            default -> throw new IllegalArgumentException("Invalid Argument.");
        }

        Competitions.getInstance().add(competition);
        ((Admin) Auth.getCurrentUser()).addOwnedCompetition(competition);
    }
}
