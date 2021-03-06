package ir.ac.kntu.core;

import ir.ac.kntu.commands.Commands;
import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.user.Admin;
import ir.ac.kntu.models.user.User;

public class Auth {
    private static User currentUser;

    public static void register(User user) {
        if (Users.getInstance().exists(user)) {
            throw new IllegalArgumentException("User currently exists.");
        }
        Users.getInstance().add(user);
        currentUser = user;
    }

    public static void login(String username, String password) {
        User user = Users.getInstance().get(u -> u.matchCredentials(username, password));
        if (user == null) {
            throw new IllegalArgumentException("Wrong username or password.");
        }
        currentUser = user;
        if (user instanceof Admin) {
            Commands.loadAdminCommands();
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Admin getCurrentAdmin() {
        if (currentUser instanceof Admin) {
            return (Admin) currentUser;
        }
        throw new IllegalStateException("Access denied!");
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static void logout() {
        if (!isLoggedIn()) {
            throw new IllegalStateException("You must login first to logout.");
        }
        currentUser = null;
    }
}
