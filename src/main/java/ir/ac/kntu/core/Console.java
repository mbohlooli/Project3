package ir.ac.kntu.core;

import ir.ac.kntu.commands.Commands;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.question.Difficulty;
import ir.ac.kntu.models.question.Question;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void listen() {
        while (true) {
            System.out.print(">>> ");
            Commands.getCommand(scanner.nextLine()).execute();
        }
    }

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static String nextLine(String pattern) {
        //TODO: make this ask for input again
        String result = scanner.nextLine();
        if (!result.matches(pattern)) {
            throw new IllegalStateException("Invalid format.");
        }
        return result;
    }

    public static int nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static double nextDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    public static boolean nextBoolean() {
        return scanner.nextLine().equals("y");
    }

    public static Classroom nextClassroom(List<Classroom> source) {
        AtomicInteger counter = new AtomicInteger(1);
        source.forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the classroom: ");
        int index = Console.nextInt() - 1;
        return source.get(index);
    }

    public static Assignment nextAssignment(Classroom source) {
        AtomicInteger counter = new AtomicInteger(1);
        if (source.getOwner().equals(Auth.getCurrentUser())) {
            source.getAssignments().forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));
        } else {
            source.getAssignments().stream().filter(a -> a.getStart().before(new Date())).forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));
        }

        System.out.println("Choose the assignment: ");
        int index = Console.nextInt() - 1;
        return source.getAssignments().get(index);
    }

    public static Question nextQuestion(List<Question> questions) {
        AtomicInteger counter = new AtomicInteger(1);
        questions.forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the question: ");
        int index = Console.nextInt() - 1;
        return questions.get(index);
    }

    public static Difficulty nextDifficulty() {
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(Difficulty.values()).toList().forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the difficulty: ");
        int index = Console.nextInt() - 1;
        return Difficulty.values()[index];
    }

    public static Date nextDate() {
        System.out.print("year: ");
        int year = nextInt();
        System.out.print("month: ");
        int month = nextInt();
        System.out.print("day: ");
        int day = nextInt();

        return new Date(year-1900, month-1, day);
    }
}
