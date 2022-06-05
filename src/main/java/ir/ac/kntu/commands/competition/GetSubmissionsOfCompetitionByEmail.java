package ir.ac.kntu.commands.competition;

import ir.ac.kntu.commands.SecureCommand;
import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.core.Patterns;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.question.Question;

public class GetSubmissionsOfCompetitionByEmail extends SecureCommand {
    @Override
    public void secureExecute() {
        Competition competition = Console.nextCompetition(Auth.getCurrentUser().getAttendedCompetitions().stream().toList());
        Question question = Console.nextQuestion(competition.getQuestions());
        System.out.print("email: ");
        String email = Console.nextLine(Patterns.EMAIL);
        question.getSubmissions(Users.getInstance().get(u -> u.getEmail().equals(email))).getSubmissions().forEach(System.out::println);
    }
}
