package ir.ac.kntu.models.user;

import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.data.Competitions;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.competition.Competition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Admin extends User {
    private ArrayList<Competition> ownedCompetitions;

    public Admin(String name, String username, String password, String email, String nationalCode, String phone) {
        super(name, username, password, email, nationalCode, phone);
        ownedCompetitions = new ArrayList<>();
    }

    @Override
    public Set<Classroom> getOwnedClassrooms() {
        return new HashSet<>(Classrooms.getInstance().all());
    }

    @Override
    public Set<Classroom> getEnrolledClassrooms() {
        return new HashSet<>();
    }

    @Override
    public boolean isOwner(Classroom classroom) {
        return true;
    }

    @Override
    public void addScore(int increment) {
    }

    @Override
    public int getPlace() {
        return 0;
    }

    public void addOwnedCompetition(Competition competition) {
        ownedCompetitions.add(competition);
    }

    public ArrayList<Competition> getOwnedCompetitions() {
        return new ArrayList<>(ownedCompetitions);
    }
}
