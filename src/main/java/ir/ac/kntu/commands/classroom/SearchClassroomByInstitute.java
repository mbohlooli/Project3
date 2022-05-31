package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;

public class SearchClassroomByInstitute extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.println("Enter the institute name: ");
        String institute = Console.nextLine();
        Classrooms.getInstance().search(c -> c.getInstitute().equals(institute)).forEach(System.out::println);
    }
}
