package ir.ac.kntu.models.question;

public class MultipleChoiceQuestion extends Question {
    private boolean autoCheck;

    private String answer;

    public MultipleChoiceQuestion(String name, int maxScore, String description, String answer, Difficulty difficulty, boolean autoCheck) {
        super(name, maxScore, description, difficulty);
        this.autoCheck = autoCheck;
        this.answer = answer;
        //TODO: add choices
    }

    public boolean isAutoCheck() {
        return autoCheck;
    }

    public void setAutoCheck(boolean autoCheck) {
        this.autoCheck = autoCheck;
    }
}
