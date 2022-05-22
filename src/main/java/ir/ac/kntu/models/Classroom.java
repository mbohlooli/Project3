package ir.ac.kntu.models;

import java.util.ArrayList;

public class Classroom {
    private String name;

    private String institute;

    private String instructor;

    private int educationYear;

    private boolean isOpen;

    private String password;

    public Classroom(String name, String institute, String instructor, int educationYear, boolean isOpen, String password) {
        this.name = name;
        this.institute = institute;
        this.instructor = instructor;
        this.educationYear = educationYear;
        this.isOpen = isOpen;
        this.password = password;
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
}
