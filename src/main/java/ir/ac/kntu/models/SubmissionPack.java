package ir.ac.kntu.models;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.question.Question;
import ir.ac.kntu.models.user.User;

import java.util.ArrayList;

public class SubmissionPack {
    private User user;

    private Question question;

    private ArrayList<Submission> submissions;

    public SubmissionPack(Question question) {
        this.question = question;
        user = Auth.getCurrentUser();
        submissions = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public Question getQuestion() {
        return question;
    }

    public ArrayList<Submission> getSubmissions() {
        return submissions;
    }

    public void addSubmission(Submission submission) {
        submissions.add(submission);
    }

    public Submission getFinalSubmission() {
        for (Submission submission: submissions) {
            if (submission.isFinal()) {
                return submission;
            }
        }
        return null;
    }
}
