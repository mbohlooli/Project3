package ir.ac.kntu;

import ir.ac.kntu.core.Console;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.User;

public class Main {
    public static void main(String[] args) {
        seed();
        Console.listen();
    }

    private static void seed() {
        Users.getInstance().add(new User("admin", "admin", "pass", "a@b.com", "0123456789", "09123456789"));
    }
}
