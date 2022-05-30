package ir.ac.kntu.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;

    private String username;

    private String password;

    private String email;

    private String nationalCode;

    private String phone;

    private Set<Classroom> ownedClassrooms;

    private Set<Classroom> enrolledClassrooms;

    public User(String name, String username, String password, String email, String nationalCode, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nationalCode = nationalCode;
        this.phone = phone;
        this.ownedClassrooms = new HashSet<>();
        this.enrolledClassrooms = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean matchCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void addClassroom(Classroom classroom) {
        enrolledClassrooms.add(classroom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) || email.equals(user.email) || nationalCode.equals(user.nationalCode) || phone.equals(user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, nationalCode, phone);
    }
}
