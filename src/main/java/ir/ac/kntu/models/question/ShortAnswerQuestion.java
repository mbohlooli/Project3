package ir.ac.kntu.models.question;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.Submission;

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
        ArrayList<Submission> submissions = submissionPacks.get(Auth.getCurrentUser()).getSubmissions();
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

    public boolean isAutoCheck() {
        return autoCheck;
    }

    public void setAutoCheck(boolean autoCheck) {
        this.autoCheck = autoCheck;
    }
}
