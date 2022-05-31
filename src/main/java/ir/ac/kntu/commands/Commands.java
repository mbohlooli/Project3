package ir.ac.kntu.commands;

import ir.ac.kntu.commands.auth.*;
import ir.ac.kntu.commands.classroom.*;

import java.util.HashMap;

public class Commands {
    private static HashMap<String, Command> commands = new HashMap<>() {
        {
            put("login", new Login());
            put("logout", new Logout());
            put("register", new Register());

            put("create_classroom", new CreateClassroom());
            put("get_owned_classrooms", new GetOwnedClassrooms());
            put("get_enrolled_classrooms", new GetEnrolledClassrooms());
            put("enroll_classroom", new EnrollClassroom());
            put("browse_classrooms", new BrowseClassrooms());
            put("search_classroom_name", new SearchClassroomByName());
            put("search_classroom_institute", new SearchClassroomByInstitute());
            put("search_classroom_instructor", new SearchClassroomByInstructor());
        }
    };

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
