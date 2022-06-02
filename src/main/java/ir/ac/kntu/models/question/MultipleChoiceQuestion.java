package ir.ac.kntu.models.question;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.Submission;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
    private boolean autoCheck;

    private int answer;

    private ArrayList<String> choices;

    public MultipleChoiceQuestion(String name, int maxScore, String description, int answer, Difficulty difficulty, boolean autoCheck, ArrayList<String> choices) {
        super(name, maxScore, description, difficulty);
        this.autoCheck = autoCheck;
        this.choices = choices;
        this.answer = answer;
    }

    @Override
    public void submitAnswer(Submission submission) {
        if (!autoCheck) {
            super.submitAnswer(submission);
            return;
        }

        submission.setScore(submission.getAnswer().equals(String.valueOf(answer)) ? maxScore : 0);
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("\n").append(description).append("\n");
        int counter = 1;
        for(String choice: choices) {
            builder.append(counter++).append(" ").append(choice);
        }
        return builder.toString();
    }
}
