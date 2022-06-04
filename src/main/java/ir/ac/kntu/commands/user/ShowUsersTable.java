package ir.ac.kntu.commands.user;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.data.Users;

public class ShowUsersTable extends SecureCommand {
    @Override
    public void secureExecute() {
        Users.getInstance().all().forEach(System.out::println);
    }
}
