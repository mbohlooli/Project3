package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;

import java.util.Date;

public class EditAssignment extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);

        System.out.println("Leave empty to not change");
        System.out.print("name: ");
        String name = Console.nextLine();
        if (!name.equals("")) {
            assignment.setName(name);
        }
        System.out.print("description: ");
        String description = Console.nextLine();
        if (!description.equals("")) {
            assignment.setDescription(description);
        }
        System.out.print("Change dates (y/n)? ");
        boolean changeDates = Console.nextBoolean();
        if (changeDates) {
            System.out.println("Start: ");
            Date start = Console.nextDate();
            System.out.println("Due: ");
            Date due = Console.nextDate();
            System.out.println("Over due: ");
            Date overDue = Console.nextDate();
            assignment.setStart(start);
            assignment.setDue(due);
            assignment.setOverDue(overDue);
        }
        System.out.print("delay coefficient: ");
        String delayCoefficient = Console.nextLine();
        if (!delayCoefficient.equals("")) {
            double coef = Double.parseDouble(delayCoefficient);
            if (coef < 0 || coef > 1) {
                throw new IllegalArgumentException("Delay coefficient must be between 0 and 1.");
            }
            assignment.setDelayCoefficient(coef);
        }
    }
}
