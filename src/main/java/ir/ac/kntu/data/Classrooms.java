package ir.ac.kntu.data;

import ir.ac.kntu.models.Classroom;

public class Classrooms extends DataTable<Classroom> {
    private static Classrooms instance = new Classrooms();

    private Classrooms() {
        super();
    }

    public static Classrooms getInstance() {
        return instance;
    }
}
