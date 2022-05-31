package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.data.Classrooms;

public class BrowseClassrooms extends SecureCommand {
    @Override
    public void secureExecute() {
        Classrooms.getInstance().all().forEach(System.out::println);
    }
}
