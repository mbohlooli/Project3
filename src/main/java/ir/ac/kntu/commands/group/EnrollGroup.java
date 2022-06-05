package ir.ac.kntu.commands.group;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Groups;
import ir.ac.kntu.models.user.Group;

public class EnrollGroup extends SecureCommand {
    @Override
    public void secureExecute() {
        Group group = Console.nextGroup(Groups.getInstance().all());
        group.addMember(Auth.getCurrentUser());
    }
}
