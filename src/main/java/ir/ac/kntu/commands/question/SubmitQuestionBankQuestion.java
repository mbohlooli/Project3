package ir.ac.kntu.commands.question;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.QuestionBank;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.question.Question;


public class SubmitQuestionBankQuestion extends SecureCommand {
    @Override
    public void secureExecute() {
        Question question = Console.nextQuestion(QuestionBank.getInstance().all());
        System.out.print("answer: ");
        String answer = Console.nextLine();
        Submission submission = new Submission(answer);
        question.submitAnswer(submission);
    }
}
