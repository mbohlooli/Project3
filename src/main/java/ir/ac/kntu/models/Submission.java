package ir.ac.kntu.models;

import java.util.Date;

public class Submission {
    private Date dateSent;

    private double delayCoefficient = 1;

    private String answer;

    private boolean isFinal = false;

    private int score;

    public Submission(String answer) {
        this.answer = answer;
        dateSent = new Date();
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return (int)(score * delayCoefficient);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public void setDelayCoefficient(double delayCoefficient) {
        this.delayCoefficient = delayCoefficient;
    }

    public Date getDateSent() {
        return dateSent;
    }
}
