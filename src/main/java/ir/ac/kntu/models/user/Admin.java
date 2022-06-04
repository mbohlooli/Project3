package ir.ac.kntu.models.user;

import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.models.Classroom;

import java.util.HashSet;
import java.util.Set;

public class Admin extends User {
    public Admin(String name, String username, String password, String email, String nationalCode, String phone) {
        super(name, username, password, email, nationalCode, phone);
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
}
