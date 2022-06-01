package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.models.Classroom;


public class EnrollClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Classrooms.getInstance().all());

        if (!classroom.isOpen()) {
            System.out.println("The classroom is not open for enrollment. Please contact the owner.");
            return;
        }
        //TODO: ask again
        if (classroom.getPassword() != null) {
            System.out.println("Enter the classroom password: ");
            String password = Console.nextLine();
            if (!classroom.getPassword().equals(password)) {
                throw new IllegalArgumentException("Invalid password.");
            }
        }

        Auth.getCurrentUser().enrollClassroom(classroom);
    }
}
