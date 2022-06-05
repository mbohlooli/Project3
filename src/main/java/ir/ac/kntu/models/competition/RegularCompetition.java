package ir.ac.kntu.models.competition;

import java.util.Date;

public class RegularCompetition extends Competition {
    private static final int MAX_CAPACITY = 50;

    public RegularCompetition(String title, Date start, Date end) {
        super(title, start, end);
    }

    @Override
    public boolean isAvailable() {
        return attenders.size() < MAX_CAPACITY;
    }

    @Override
    public boolean isVisible() {
        return isAvailable();
    }
}
