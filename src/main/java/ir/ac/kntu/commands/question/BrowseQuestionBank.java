package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;

public class BrowseQuestionBank extends SecureCommand {
    @Override
    public void secureExecute() {
        System.out.print("Sort by difficulty (y/n)? (Default is time) ");
        boolean sortByDifficulty = Console.nextBoolean();
        QuestionBank.getInstance().all().stream()
                .sorted((q1,q2) -> (sortByDifficulty) ? q1.getDifficulty().compareTo(q2.getDifficulty()) : q1.getCreatedAt().compareTo(q2.getCreatedAt()))
                .forEach(System.out::println);
    }
}
