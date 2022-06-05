package ir.ac.kntu.models.user;

import ir.ac.kntu.models.competition.Competition;
import ir.ac.kntu.models.competition.SpecialCompetition;

import java.util.ArrayList;

public class Group extends User {
    private ArrayList<User> members;

    public Group(String name) {
        super(name, null, null, null, null, null);
        members = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public ArrayList<User> getMembers() {
        return new ArrayList<>(members);
    }

    public boolean contains(User user) {
        return members.contains(user);
    }

    @Override
    public void attendCompetition(Competition competition) {
        if (((SpecialCompetition)competition).getGroupCapacity() > members.size()) {
            throw new IllegalStateException("Group too large");
        }
        competition.addAttender(this);
    }

    @Override
    public String toString() {
        return "Group{" + super.getName() + '}';
    }
}
