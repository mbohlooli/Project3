package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;
import ir.ac.kntu.models.question.Question;

public class BrowseSubmissionsOfQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Question question = Console.nextQuestion(QuestionBank.getInstance().all());
        question.getSubmissions(Auth.getCurrentUser()).getSubmissions().forEach(System.out::println);
    }
}
