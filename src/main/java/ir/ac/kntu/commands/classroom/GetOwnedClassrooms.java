package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;

public class GetOwnedClassrooms extends SecureCommand {
    @Override
    public void secureExecute() {
        Auth.getCurrentUser().getOwnedClassrooms().forEach(System.out::println);
    }
}
