package ir.ac.kntu;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.Assignment;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        seed();
        Console.start();
    }

    private static void seed() {
        Users.getInstance().add(new Admin("admin", "admin", "pass", "a@b.com", "0123456789", "09123456789"));
        User user = new User("user", "user", "pass", "b@b.com", "0123456781", "09123156789");
        Users.getInstance().add(user);
        Auth.login("admin", "pass");
        Classroom classroom = new Classroom("class1", "institute1", "instructor1", 1401, true, null, "");
        user.enrollClassroom(classroom);
        Classrooms.getInstance().add(classroom);
        Classrooms.getInstance().add(new Classroom("class2", "institute2", "instructor2", 1401, true, "pass", ""));
        Date yesterday = new Date(System.currentTimeMillis()-24*60*60*1000);
        Date tomorrow = new Date(System.currentTimeMillis()+24*60*60*1000);
        Date twoDaysAhead = new Date(System.currentTimeMillis()+2*24*60*60*1000);
        classroom.addAssignment(new Assignment("assignment1", "description", yesterday, tomorrow, twoDaysAhead, 0.8, classroom));
        Auth.logout();
    }
}
