package ir.ac.kntu.commands.classroom;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.models.Classroom;

public class DeleteClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());

        System.out.print("Are you sure to delete this classroom?(y/n) ");
        boolean sure = Console.nextBoolean();
        if (sure) {
            classroom.getOwner().removeOwnedClassroom(classroom);
            classroom.getStudents().forEach(s -> s.removeEnrolledClassroom(classroom));
            Classrooms.getInstance().remove(classroom);
        }
    }
}
