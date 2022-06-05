package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.user.Admin;

import java.util.Date;

public class EditCompetition extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(((Admin) Auth.getCurrentUser()).getOwnedCompetitions());

        System.out.print("title");
        String title = Console.nextLine();
        if (!title.equals("")) {
            competition.setTitle(title);
        }
        System.out.print("Change dates (y/n)?");
        boolean changeDates = Console.nextBoolean();
        if (changeDates) {
            System.out.print("start: ");
            Date start = Console.nextDate();
            System.out.print("end: ");
            Date end = Console.nextDate();
            if (start.before(end)) {
                throw new IllegalArgumentException("End cannot be before start.");
            }
            competition.setStart(start);
            competition.setEnd(end);
        }
    }
}
