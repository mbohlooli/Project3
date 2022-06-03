package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;

public class AddQuestionToQuestionBank extends SecureCommand {
    @Override
    public void secureExecute() {
        QuestionBank.getInstance().add(Console.nextQuestion());
    }
}
