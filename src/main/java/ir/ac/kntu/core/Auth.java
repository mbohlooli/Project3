package ir.ac.kntu.core;

import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.User;

public class Auth {
    private static User currentUser;

    public static void register(User user) {
        //TODO: add validation
        Users.getInstance().add(user);
        currentUser = user;
    }

    public static void login(String username, String password) {
        User user = Users.getInstance().get(u -> u.matchCredentials(username, password));
        if (user == null) {
            throw new IllegalArgumentException("Wrong username or password.");
        }
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static void logout() {
        currentUser = null;
    }
}
