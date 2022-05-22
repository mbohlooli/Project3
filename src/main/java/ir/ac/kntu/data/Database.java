package ir.ac.kntu.data;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public static Map<String, DataTable> tables = new HashMap<>() {
        {
            put("Users", new DataTable());
            put("Classrooms", new DataTable());
        }
    };
}
