package ir.ac.kntu.models.competition;

import ir.ac.kntu.models.user.User;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

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

    @Override
    public void end() {
        List<User> top = attenders.stream().sorted(Comparator.comparingInt(this::getScore)).toList().subList(0,5);
        top.forEach(u -> u.addScore(20));
    }
}
