package ir.ac.kntu.data;

import java.util.*;
import java.util.function.Predicate;

public abstract class DataTable<T> {
    private ArrayList<T> entries;

    DataTable() {
        this.entries = new ArrayList<>();
    }

    public void add(T entry) {
        entries.add(entry);
    }

    public void remove(T entry) {
        entries.remove(entry);
    }

    public ArrayList<T> search(Predicate<T> query) {
        return new ArrayList<>(entries.stream().filter(query).toList());
    }

    public T get(Predicate<T> query) {
        List<T> result = entries.stream().filter(query).toList();
        return (result.size() != 0) ? result.get(0) : null;
    }

    public ArrayList<T> all() {
        return entries;
    }

    public ArrayList<T> all(Comparator<T> comparator) {
        return new ArrayList<>(entries.stream().sorted(comparator).toList());
    }
}
