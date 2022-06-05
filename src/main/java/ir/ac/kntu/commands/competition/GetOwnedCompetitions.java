package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.user.Admin;

public class GetOwnedCompetitions extends SecureCommand {
    @Override
    public void secureExecute() {
        ((Admin) Auth.getCurrentUser()).getOwnedCompetitions().forEach(System.out::println);
    }
}
