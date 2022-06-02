package ir.ac.kntu.models.question;

public class MultipleChoiceQuestion extends Question {
    private boolean autoCheck;

    public MultipleChoiceQuestion(String name, int maxScore, String description, String answer, Difficulty difficulty, boolean autoCheck) {
        super(name, maxScore, description, answer, difficulty);
        this.autoCheck = autoCheck;
    }

    public boolean isAutoCheck() {
        return autoCheck;
    }

    public void setAutoCheck(boolean autoCheck) {
        this.autoCheck = autoCheck;
    }
}
