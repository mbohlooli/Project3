package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;

public class GetEnrolledClassrooms extends SecureCommand {
    @Override
    public void secureExecute() {
        Auth.getCurrentUser().getEnrolledClassrooms().forEach(System.out::println);
    }
}
