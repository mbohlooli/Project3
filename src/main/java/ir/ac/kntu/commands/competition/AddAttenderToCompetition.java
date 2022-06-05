package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

public class AddAttenderToCompetition extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Auth.getCurrentAdmin().getOwnedCompetitions());
        System.out.print("Use email (y) or national code (n): ");
        boolean useEmail = Console.nextBoolean();
        User user;
        if (useEmail) {
            System.out.print("email: ");
            String email = Console.nextLine(Patterns.EMAIL);
            user = Users.getInstance().get(u -> u.getEmail().equals(email));
            if (user == null) {
                throw new IllegalArgumentException("No user with this email found.");
            }
        } else {
            System.out.print("national code: ");
            String nationalCode = Console.nextLine(Patterns.NATIONAL_CODE);
            user = Users.getInstance().get(u -> u.getNationalCode().equals(nationalCode));
            if (user == null) {
                throw new IllegalArgumentException("No user with this email found.");
            }
        }
        user.attendCompetition(competition);
    }
}
