package ir.ac.kntu.models.question;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.SubmissionPack;

import java.util.ArrayList;

public class ShortAnswerQuestion extends Question {
    private boolean autoCheck;

    private String answer;

    public ShortAnswerQuestion(String name, int maxScore, String description, String answer, Difficulty difficulty, boolean autoCheck) {
        super(name, maxScore, description, difficulty);
        this.autoCheck = autoCheck;
        this.answer = answer;
    }

    @Override
    public void submitAnswer(Submission submission) {
        if (!autoCheck) {
            super.submitAnswer(submission);
            return;
        }

        submission.setScore(submission.getAnswer().equals(answer) ? maxScore : 0);
        ArrayList<Submission> submissions = getOrCreateSubmissionPack().getSubmissions();
        for (Submission s: submissions) {
            if (s.getScore() > submission.getScore()) {
                return;
            } else {
                s.setFinal(false);
            }
        }
        submission.setFinal(true);
        submissionPacks.get(Auth.getCurrentUser()).addSubmission(submission);
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("auto check: ");
        String autoCheck = Console.nextLine();
        if (!autoCheck.equals("")) {
            this.autoCheck = autoCheck.equals("y");
        }
        System.out.println("answer: ");
        String answer = Console.nextLine();
        if(!answer.equals("")) {
            this.answer = answer;
        }
    }

    public boolean isAutoCheck() {
        return autoCheck;
    }

    public void setAutoCheck(boolean autoCheck) {
        this.autoCheck = autoCheck;
    }
}
