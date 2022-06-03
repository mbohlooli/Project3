package ir.ac.kntu.commands.assignment;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.question.*;

public class AddQuestionToAssignment extends SecureCommand {
    @Override
    public void secureExecute() {
        Classroom classroom = Console.nextClassroom(Auth.getCurrentUser().getOwnedClassrooms().stream().toList());
        Assignment assignment = Console.nextAssignment(classroom);
        System.out.println("Do you want to add question from question bank (y/n)?");
        boolean importFromQuestionBank = Console.nextBoolean();
        Question question;
        if (importFromQuestionBank) {
            question = Console.nextQuestion(QuestionBank.getInstance().all());
        } else {
            question = Console.nextQuestion();
            System.out.println("Add to question bank (y/n)?");
            boolean addToQuestionBank = Console.nextBoolean();
            if (addToQuestionBank) {
                QuestionBank.getInstance().add(question);
            }
        }
        assignment.addQuestion(question);
    }
}
