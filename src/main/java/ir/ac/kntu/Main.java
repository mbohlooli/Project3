package ir.ac.kntu;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Classrooms;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.Classroom;
import ir.ac.kntu.models.User;

public class Main {
    public static void main(String[] args) {
        seed();
        Console.listen();
    }

    private static void seed() {
        Users.getInstance().add(new User("admin", "admin", "pass", "a@b.com", "0123456789", "09123456789"));
        Users.getInstance().add(new User("user", "user", "pass", "b@b.com", "0123456781", "09123156789"));
        Auth.login("admin", "pass");
        Classrooms.getInstance().add(new Classroom("class1", "institute1", "instructor1", 1401, true, null));
        Classrooms.getInstance().add(new Classroom("class2", "institute2", "instructor2", 1401, true, "pass"));
        Auth.logout();
    }
}
