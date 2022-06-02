package ir.ac.kntu.data;

import ir.ac.kntu.models.question.Question;

public class QuestionBank extends DataTable<Question> {
    private static QuestionBank instance = new QuestionBank();

    private QuestionBank() {}

    public static QuestionBank getInstance() {
        return instance;
    }
}
