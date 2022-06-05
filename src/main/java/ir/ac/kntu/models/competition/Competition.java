package ir.ac.kntu.models.competition;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.question.Question;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

import java.util.ArrayList;
import java.util.Date;

public abstract class Competition {
    protected String title;

    protected Date start;

    protected Date end;

    protected ArrayList<Question> questions;

    protected ArrayList<User> attenders;

    protected Admin owner;

    public Competition(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
        questions = new ArrayList<>();
        attenders = new ArrayList<>();
        owner = Auth.getCurrentAdmin();
    }

    @Override
    public String toString() {
        return "Competition{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
