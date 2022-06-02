package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.data.QuestionBank;

public class BrowseQuestionBank extends SecureCommand {
    @Override
    public void secureExecute() {
        QuestionBank.getInstance().all().forEach(System.out::println);
    }
}
