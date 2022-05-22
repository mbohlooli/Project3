package ir.ac.kntu.data;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class DataTable<T> {
    private Set<T> entries;

    DataTable() {
        this.entries = new HashSet<>();
    }

    public void add(T entry) {
        entries.add(entry);
    }

    public void remove(T entry) {
        entries.remove(entry);
    }

    public Set<T> search(Predicate<T> query) {
        return new HashSet<>(entries.stream().filter(query).toList());
    }
}
