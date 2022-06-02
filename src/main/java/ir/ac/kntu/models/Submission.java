package ir.ac.kntu.models;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.question.Question;

import java.util.Date;

public class Submission {
    private Date dateSent;

    private double delayCoefficient;

    private String answer;

    private int score;

    public Submission(double delayCoefficient, String answer) {
        this.delayCoefficient = delayCoefficient;
        this.answer = answer;
        dateSent = new Date();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
