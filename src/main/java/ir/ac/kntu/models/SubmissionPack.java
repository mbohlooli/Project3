package ir.ac.kntu.models;

import ir.ac.kntu.models.question.Question;

import java.util.ArrayList;

public class SubmissionPack {
    private User user;

    private Question question;

    private ArrayList<Submission> submissions;

    public SubmissionPack(Question question) {
        this.question = question;
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

    public void getFinalSubmission() {
        //TODO: complete this
    }
}
