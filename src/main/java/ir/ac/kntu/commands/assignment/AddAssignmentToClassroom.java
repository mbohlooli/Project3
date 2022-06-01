package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AddAssignmentToClassroom extends SecureCommand {
    @Override
    public void secureExecute() {
        List<Classroom> classrooms = Auth.getCurrentUser().getOwnedClassrooms().stream().toList();

        AtomicInteger counter = new AtomicInteger(1);
        classrooms.forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the classroom index you want to add student to: ");
        int index = Console.nextInt() - 1;
        Classroom classroom = classrooms.get(index);

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
