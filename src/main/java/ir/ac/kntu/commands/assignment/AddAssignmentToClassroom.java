package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;

import java.util.Date;


public class AddAssignmentToClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());

        System.out.print("name: ");
        String name = Console.nextLine();
        System.out.print("description: ");
        String description = Console.nextLine();
        System.out.print("start date: ");
        Date start = Console.nextDate();
        System.out.print("due date: ");
        Date due = Console.nextDate();
        if (due.before(start)) {
            throw new IllegalArgumentException("Due cannot be before start.");
        }
        System.out.print("over due date: ");
        Date overDue = Console.nextDate();
        if (overDue.before(due)) {
            throw new IllegalArgumentException("Over due cannot be before due.");
        }
        System.out.print("delay coefficient: ");
        double delayCoefficient = Console.nextDouble();
        //TODO: add questions

        Assignment assignment = new Assignment(name, description, start, due, overDue, delayCoefficient, classroom);
        classroom.addAssignment(assignment);
    }
}
