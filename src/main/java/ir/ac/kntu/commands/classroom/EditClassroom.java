package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Classroom;

public class EditClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        System.out.println("Leave empty to not change.");
        System.out.print("name: ");
        String name = Console.nextLine();
        if(!name.equals("")) {
            classroom.setName(name);
        }
        System.out.print("institute: ");
        String institute = Console.nextLine();
        if(!institute.equals("")) {
            classroom.setInstitute(institute);
        }
        System.out.print("instructor: ");
        String instructor = Console.nextLine();
        if(!instructor.equals("")) {
            classroom.setInstructor(instructor);
        }
        System.out.print("education year: ");
        String educationYear = Console.nextLine();
        if(!educationYear.equals("")) {
            classroom.setEducationYear(Integer.parseInt(educationYear));
        }
        System.out.println("description: ");
        String description = Console.nextLine();
        if(!description.equals("")) {
            classroom.setDescription(description);
        }
        System.out.print("is open(y/n): ");
        String isOpen = Console.nextLine();
        if(!isOpen.equals("")) {
            classroom.setOpen(isOpen.equals("y"));
        }
        System.out.print("password: ");
        String password = Console.nextLine();
        if(!password.equals("")) {
            classroom.setPassword(password);
        }
    }
}
