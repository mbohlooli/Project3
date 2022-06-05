package ir.ac.kntu.data;

import ir.ac.kntu.models.competition.Competition;

public class Competitions extends DataTable<Competition> {
    private static Competitions instance = new Competitions();

    private Competitions() {
        super();
    }

    public static Competitions getInstance() {
        return instance;
    }
}
