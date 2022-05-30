package ir.ac.kntu.data;

import ir.ac.kntu.models.User;

import java.util.Set;

public class Users extends DataTable<User> {
    private static Users instance = new Users();

    private Users() {
        super();
    }

    public static Users getInstance() {
        return instance;
    }

    public boolean exists(User user) {
        Set<User> users = search(u -> u.equals(user));
        return users.size() > 0;
    }
}
