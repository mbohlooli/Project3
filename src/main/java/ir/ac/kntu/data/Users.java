package ir.ac.kntu.data;

import ir.ac.kntu.models.User;

public class Users extends DataTable<User> {
    private static Users instance = new Users();

    private Users() {
        super();
    }

    public static Users getInstance() {
        return instance;
    }
}
