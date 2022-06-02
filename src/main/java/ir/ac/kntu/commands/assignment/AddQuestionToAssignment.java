package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.question.*;

import java.util.ArrayList;

public class AddQuestionToAssignment extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);
        System.out.print("name: ");
        String name = Console.nextLine();
        System.out.print("max score: ");
        int maxScore = Console.nextInt();
        System.out.print("description: ");
        String description = Console.nextLine();
        System.out.print("difficulty: ");
        Difficulty difficulty = Console.nextDifficulty();
        System.out.println("Select your question type: ");
        System.out.println("1) Descriptive  2) Short answer  3) Multiple choice 4) Fill in blanks");
        int type = Console.nextInt();
        if (type < 1 || type > 4) {
            throw new IllegalArgumentException("Invalid Argument.");
        }
        Question question = null;
        switch (type) {
            case 1 -> question = new DescriptiveQuestion(name, maxScore, description, difficulty);
            case 2 -> {
                System.out.print("answer: ");
                String answer = Console.nextLine();
                System.out.print("auto check: ");
                boolean autoCheck = Console.nextBoolean();
                question = new ShortAnswerQuestion(name, maxScore, description, answer, difficulty, autoCheck);
            }
            case 3 -> {
                ArrayList choices = getChoices();
                System.out.print("answer: ");
                int answer = Console.nextInt();
                if (answer < 1 && answer > choices.size()) {
                    throw new IllegalArgumentException("Invalid Argument.");
                }
                System.out.print("auto check: ");
                boolean autoCheck = Console.nextBoolean();
                question = new MultipleChoiceQuestion(name, maxScore, description, answer, difficulty, autoCheck, choices);
            }
            case 4 -> question = new FillInBlanksQuestion(name, maxScore, description, difficulty);
            default ->  question = null;
        }
        assignment.addQuestion(question);
    }

    private ArrayList<String> getChoices() {
        System.out.print("number of choices: ");
        int count = Console.nextInt();
        ArrayList<String> choices = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("choice " + i + ": ");
            choices.add(Console.nextLine());
        }
        return choices;
    }
}
