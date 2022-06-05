package ir.ac.kntu.models.competition;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.question.Question;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Override
    public String toString() {
        return "Competition{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
