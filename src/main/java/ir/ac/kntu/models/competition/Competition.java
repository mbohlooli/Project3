package ir.ac.kntu.models.competition;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.question.Question;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

import java.util.*;

public abstract class Competition {
    protected String title;

    protected Date start;

    protected Date end;

    protected ArrayList<Question> questions;

    protected Set<User> attenders;

    protected Admin owner;

    public Competition(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
        questions = new ArrayList<>();
        attenders = new HashSet<>();
        owner = Auth.getCurrentAdmin();
    }

    public void addAttender(User attender) {
        if (!isAvailable()) {
            throw new IllegalStateException("The competition is not available for more users now.");
        }
        attenders.add(attender);
    }

    public Set<User> getAttenders() {
        return new HashSet<>(attenders);
    }

    public abstract boolean isAvailable();

    public abstract boolean isVisible();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public void submitAnswer(Question question, Submission submission) {
        question.submitAnswer(submission);
    }

    public void displayScoreTable() {
        List<User> users = attenders.stream().sorted(Comparator.comparingInt(this::getScore)).toList();
        Collections.reverse(users);
        int place = 1;
        int previousScore = getScore(users.get(0));
        System.out.print("# ");
        for (Question question: questions) {
            System.out.print(question.getName() + " ");
        }
        System.out.print("total");
        System.out.println();
        for (User student: users) {
            System.out.print(place + " ");
            if (previousScore < getScore(student)) {
                place++;
            }
            System.out.print(student.getUsername() + " ");
            System.out.print(student.getName() + " ");
            for (Question question: questions) {
                Submission submission = question.getSubmissions(student).getFinalSubmission();
                System.out.print(submission.getScore() + " ");
            }
            System.out.print(getScore(student) + " ");
            System.out.println();
        }
    }

    protected int getScore(User attender) {
        int sum = 0;
        for(Question question: questions) {
            sum += question.getSubmissions(attender).getFinalSubmission().getScore();
        }
        return sum;
    }

    public abstract void end();

    @Override
    public String toString() {
        return "Competition{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
