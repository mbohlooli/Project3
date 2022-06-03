package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;

public class BrowseQuestionBank extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.print("Sort by time (y/n)? (Default is difficulty) ");
        boolean sortByTime = Console.nextBoolean();
        QuestionBank.getInstance().all().stream()
                .sorted((q1,q2) -> (sortByTime) ? q1.getCreatedAt().compareTo(q2.getCreatedAt()) : q1.getDifficulty().compareTo(q2.getDifficulty()))
                .forEach(System.out::println);
    }
}
