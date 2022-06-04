package ir.ac.kntu.models;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.models.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Classroom {
    private String name;

    private String institute;

    private String instructor;

    private int educationYear;

    private boolean isOpen;

    private String password;

    private String description;

    private User owner;

    private Set<User> assistants;

    private Set<User> students;

    private ArrayList<Assignment> assignments;

    public Classroom(String name, String institute, String instructor, int educationYear, boolean isOpen, String password, String description) {
        this.name = name;
        this.institute = institute;
        this.instructor = instructor;
        this.educationYear = educationYear;
        this.isOpen = isOpen;
        this.password = password;
        this.description = description;
        this.students = new HashSet<>();
        this.assignments = new ArrayList<>();
        owner = Auth.getCurrentUser();
        assistants = new HashSet<>();
        assistants.add(owner);
        Auth.getCurrentUser().addOwnedClassroom(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getEducationYear() {
        return educationYear;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addStudent(User user) {
        students.add(user);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public ArrayList<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }

    public User getOwner() {
        return owner;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void deleteAssignment(Assignment assignment) {
        assignments.remove(assignment);
    }

    public ArrayList<User> getAssistants() {
        return new ArrayList<>(assistants);
    }

    public void addAssistant(User user) {
        assistants.add(user);
        user.addOwnedClassroom(this);
    }

    public void removeAssistant(User user) {
        assistants.remove(user);
        user.removeOwnedClassroom(this);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                ", institute='" + institute + '\'' +
                ", instructor='" + instructor + '\'' +
                ", educationYear=" + educationYear +
                ", isOpen=" + isOpen +
                '}';
    }
}
