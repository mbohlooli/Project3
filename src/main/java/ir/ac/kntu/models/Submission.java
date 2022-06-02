package ir.ac.kntu.models;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.question.Question;

import java.util.Date;

public class Submission {
    private Question question;

    private User user;

    private Date dateSent;

    private double delayCoefficient;

    private int score;

    private String answer;

    public Submission(Question question, double delayCoefficient, String answer) {
        this.question = question;
        this.delayCoefficient = delayCoefficient;
        this.answer = answer;
        user = Auth.getCurrentUser();
        dateSent = new Date();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
