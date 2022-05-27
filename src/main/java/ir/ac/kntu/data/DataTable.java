package ir.ac.kntu.data;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public abstract class DataTable<T> {
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

    public T get(Predicate<T> query) {
        return entries.stream().filter(query).toList().get(0);
    }

    public Set<T> all() {
        return entries;
    }

    public Set<T> all(Comparator<T> comparator) {
        return new HashSet<>(entries.stream().sorted(comparator).toList());
    }
}
