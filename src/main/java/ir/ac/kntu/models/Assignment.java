package ir.ac.kntu.models;

import ir.ac.kntu.models.question.Question;

import java.util.ArrayList;
import java.util.Date;

public class Assignment {
    private String name;

    private String description;

    private Date start;

    private Date due;

    private Date overDue;

    private double delayCoefficient;

    private Classroom classroom;

    private ArrayList<Question> questions;

    public Assignment(String name, String description, Date start, Date due, Date overDue, double delayCoefficient, Classroom classroom) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.due = due;
        this.overDue = overDue;
        this.delayCoefficient = delayCoefficient;
        this.classroom = classroom;
        questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Date getOverDue() {
        return overDue;
    }

    public void setOverDue(Date overDue) {
        this.overDue = overDue;
    }

    public double getDelayCoefficient() {
        return delayCoefficient;
    }

    public void setDelayCoefficient(double delayCoefficient) {
        this.delayCoefficient = delayCoefficient;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void deleteQuestion(Question question) {
        questions.remove(question);
    }

    public void submitAnswer(Question question, Submission submission) {
        Date now = new Date();

        if (now.after(due) && now.before(overDue)) {
            submission.setDelayCoefficient(delayCoefficient);
        }

        question.submitAnswer(submission);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", due=" + due +
                ", overDue=" + overDue +
                ", delayCoefficient=" + delayCoefficient +
                ", classroom=" + classroom.getName() +
                ", questions=" + questions.stream().map(Question::getName) +
                '}';
    }
}
