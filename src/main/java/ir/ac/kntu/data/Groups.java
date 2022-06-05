package ir.ac.kntu.data;

import ir.ac.kntu.models.user.Group;

public class Groups extends DataTable<Group> {
    private static Groups instance = new Groups();

    private Groups() {}

    public static Groups getInstance() {
        return instance;
    }
}
