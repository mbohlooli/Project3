package ir.ac.kntu.commands.group;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Groups;
import ir.ac.kntu.models.user.Group;

public class CreateGroup extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.print("name: ");
        String name = Console.nextLine();
        Group group = new Group(name);
        group.addMember(Auth.getCurrentUser());
        Groups.getInstance().add(group);
    }
}
