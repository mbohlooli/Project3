package ir.ac.kntu.models.competition;

import ir.ac.kntu.models.user.Group;
import ir.ac.kntu.models.user.User;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SpecialCompetition extends Competition {
    private static final int MAX_CAPACITY = 100;

    private int groupCapacity;

    public SpecialCompetition(String title, Date start, Date end, int groupCapacity) {
        super(title, start, end);
        this.groupCapacity = groupCapacity;
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
        List<User> groups = attenders.stream().sorted(Comparator.comparingInt(this::getScore)).toList().subList(0,10);
        groups.forEach(g -> ((Group)g).getMembers().forEach(u -> u.addScore(25)));
    }

    public int getGroupCapacity() {
        return groupCapacity;
    }
}
