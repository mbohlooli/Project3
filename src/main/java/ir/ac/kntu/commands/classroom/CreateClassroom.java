package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.models.Classroom;

public class CreateClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.print("name: ");
        String name = Console.nextLine();
        System.out.print("institute: ");
        String institute = Console.nextLine();
        System.out.print("instructor: ");
        String instructor = Console.nextLine();
        System.out.print("education year: ");
        int educationYear = Console.nextInt();
        System.out.println("description: ");
        String description = Console.nextLine();
        System.out.print("is open(y/n): ");
        boolean isOpen = Console.nextBoolean();
        System.out.print("is private(y/n): ");
        boolean isPrivate = Console.nextBoolean();
        String password = null;
        if (isPrivate) {
            System.out.print("password: ");
            password = Console.nextLine();
        }

        Classroom classroom = new Classroom(name, institute, instructor, educationYear, isOpen, password, description);
        Classrooms.getInstance().add(classroom);
    }
}
