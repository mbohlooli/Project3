package ir.ac.kntu.core;

import ir.ac.kntu.commands.Commands;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.User;
import ir.ac.kntu.models.question.*;

import java.util.*;
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

    public static Question nextQuestion() {
        System.out.print("name: ");
        String name = Console.nextLine();
        System.out.print("max score: ");
        int maxScore = Console.nextInt();
        System.out.print("description: ");
        String description = Console.nextLine();
        System.out.println("difficulty: ");
        Difficulty difficulty = Console.nextDifficulty();
        System.out.println("Select your question type: ");
        System.out.println("1) Descriptive  2) Short answer  3) Multiple choice  4) Fill in blanks");
        int type = Console.nextInt();
        Question question;
        switch (type) {
            case 1 -> question = new DescriptiveQuestion(name, maxScore, description, difficulty);
            case 2 -> {
                System.out.print("answer: ");
                String answer = Console.nextLine();
                System.out.print("auto check(y/n): ");
                boolean autoCheck = Console.nextBoolean();
                question = new ShortAnswerQuestion(name, maxScore, description, answer, difficulty, autoCheck);
            }
            case 3 -> {
                System.out.print("number of choices: ");
                int count = Console.nextInt();
                ArrayList<String> choices = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    System.out.print("choice " + (i+1) + ": ");
                    choices.add(Console.nextLine());
                }
                System.out.print("answer: ");
                int answer = Console.nextInt();
                if (answer < 1 && answer > choices.size()) {
                    throw new IllegalArgumentException("Invalid Argument.");
                }
                System.out.print("auto check(y/n): ");
                boolean autoCheck = Console.nextBoolean();
                question = new MultipleChoiceQuestion(name, maxScore, description, answer, difficulty, autoCheck, choices);
            }
            case 4 -> question = new FillInBlanksQuestion(name, maxScore, description, difficulty);
            default ->  throw new IllegalArgumentException("Invalid Argument.");
        }
        return question;
    }

    public static Difficulty nextDifficulty() {
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(Difficulty.values()).toList().forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the difficulty: ");
        int index = Console.nextInt() - 1;
        return Difficulty.values()[index];
    }

    public static User nextUser(List<User> source) {
        AtomicInteger counter = new AtomicInteger(1);
        source.forEach(c -> System.out.println(counter.getAndIncrement() + "- " + c));

        System.out.println("Choose the classroom: ");
        int index = Console.nextInt() - 1;
        return source.get(index);
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
