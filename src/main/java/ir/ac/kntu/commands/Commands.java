package ir.ac.kntu.commands;

import ir.ac.kntu.commands.auth.*;
import ir.ac.kntu.commands.classroom.*;
import ir.ac.kntu.commands.assignment.*;
import ir.ac.kntu.commands.question.AddQuestionToQuestionBank;
import ir.ac.kntu.commands.question.BrowseQuestionBank;
import ir.ac.kntu.commands.question.SubmitQuestionBankQuestion;
import ir.ac.kntu.commands.user.*;

import java.util.HashMap;

public class Commands {
    private static HashMap<String, Command> commands = new HashMap<>() {
        {
            put("login", new Login());
            put("logout", new Logout());
            put("register", new Register());

            put("search_user_national_code", new SearchUserByNationalCode());
            put("search_user_email", new SearchUserByEmail());

            put("create_classroom", new CreateClassroom());
            put("get_owned_classrooms", new GetOwnedClassrooms());
            put("get_enrolled_classrooms", new GetEnrolledClassrooms());
            put("enroll_classroom", new EnrollClassroom());
            put("browse_classrooms", new BrowseClassrooms());
            put("search_classroom_name", new SearchClassroomByName());
            put("search_classroom_institute", new SearchClassroomByInstitute());
            put("search_classroom_instructor", new SearchClassroomByInstructor());
            put("add_student_to_classroom", new AddStudentToClassroom());
            put("edit_classroom", new EditClassroom());
            put("delete_classroom", new DeleteClassroom());

            put("add_assignment_to_classroom", new AddAssignmentToClassroom());
            put("get_assignments_of_classroom", new GetAssignmentsOfClassroom());
            put("edit_assignment_of_classroom", new EditAssignment());
            put("delete_assignment_of_classroom", new DeleteAssignmentFromClassroom());
            put("add_question_to_assignment", new AddQuestionToAssignment());
            put("submit_assignment_question", new SubmitAssignmentQuestion());

            put("add_question_to_question_bank", new AddQuestionToQuestionBank());
            put("browse_question_bank", new BrowseQuestionBank());
            put("submit_question_bank_question", new SubmitQuestionBankQuestion());
        }
    };

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
