package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;

public class SearchClassroomByName extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.println("Enter the classroom name: ");
        String institute = Console.nextLine();
        Classrooms.getInstance().search(c -> c.getName().equals(institute)).forEach(System.out::println);
    }
}
