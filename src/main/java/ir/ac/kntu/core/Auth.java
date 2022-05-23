package ir.ac.kntu.core;

import ir.ac.kntu.data.Users;
import ir.ac.kntu.models.User;

import java.util.Set;

public class Auth {
    private User currentUser;

    public void register(User user) {
        //TODO: add validation
        Users.getInstance().add(user);
        currentUser = user;
    }

    public void login(String email, String password) {
        //TODO: make a validate method in user
        Set<User> users = Users.getInstance().search(user -> user.getEmail().equals(email) && user.getPassword().equals(password));
        if (users.size() == 1) {
            this.currentUser = users.iterator().next();
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void logout() {
        currentUser = null;
    }
}
