package ir.ac.kntu.models.question;

public class ShortAnswerQuestion extends Question {
    private boolean autoCheck;

    private String answer;

    public ShortAnswerQuestion(String name, int maxScore, String description, String answer, Difficulty difficulty, boolean autoCheck) {
        super(name, maxScore, description, difficulty);
        this.autoCheck = autoCheck;
        this.answer = answer;
    }

    public boolean isAutoCheck() {
        return autoCheck;
    }

    public void setAutoCheck(boolean autoCheck) {
        this.autoCheck = autoCheck;
    }
}
