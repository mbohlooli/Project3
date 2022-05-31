package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;

public class SearchClassroomByInstructor extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.println("Enter the instructor name: ");
        String instructor = Console.nextLine();
        Classrooms.getInstance().search(c -> c.getInstructor().equals(instructor)).forEach(System.out::println);
    }
}
