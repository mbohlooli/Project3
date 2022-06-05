package ir.ac.kntu.commands;

import ir.ac.kntu.commands.auth.*;
import ir.ac.kntu.commands.classroom.*;
import ir.ac.kntu.commands.assignment.*;
import ir.ac.kntu.commands.competition.*;
import ir.ac.kntu.commands.question.*;
import ir.ac.kntu.commands.user.*;

import java.util.HashMap;

public class Commands {
    private static HashMap<String, Command> userCommands = new HashMap<>() {
        {
            put("login", new Login());
            put("logout", new Logout());
            put("register", new Register());
            put("exit", () -> System.exit(0));
            put("continue_as_guest", new ContinueAsGuest());

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
            put("add_assistant_to_classroom", new AddAssistantToClassroom());
            put("get_classroom_assistants", new GetClassroomAssistants());
            put("remove_assistant_from_classroom", new RemoveAssistantFromClassroom());

            put("add_assignment_to_classroom", new AddAssignmentToClassroom());
            put("get_assignments_of_classroom", new GetAssignmentsOfClassroom());
            put("edit_assignment_of_classroom", new EditAssignment());
            put("delete_assignment_of_classroom", new DeleteAssignmentFromClassroom());
            put("add_question_to_assignment", new AddQuestionToAssignment());
            put("submit_assignment_question", new SubmitAssignmentQuestion());
            put("delete_question_from_assignment", new DeleteQuestionFromAssignment());
            put("edit_assignment_question", new EditAssignmentQuestion());
            put("browse_submissions_of_assignment_question", new BrowseSubmissionsOfAssignmentQuestion());
            put("get_final_submission_of_assignment_question", new GetFinalSubmissionForAssignmentQuestion());
            put("set_assignment_score_table_visibility", new SetScoreTableVisibility());
            put("get_score_table_of_assignment", new GetScoreTableOfAssignment());

            put("add_question_to_question_bank", new AddQuestionToQuestionBank());
            put("browse_question_bank", new BrowseQuestionBank());
            put("submit_question_bank_question", new SubmitQuestionBankQuestion());
            put("edit_question_bank_question", new EditQuestion());
            put("browse_submissions_of_question_bank_question", new BrowseSubmissionsOfQuestion());
            put("get_final_submission_of_question_bank_question", new GetFinalSubmissionForAssignmentQuestion());
        }
    };

    private static HashMap<String, Command> guestCommands = new HashMap<>() {
        {
            put("login", new Login());
            put("logout", new Logout());
            put("register", new Register());
            put("exit", () -> System.exit(0));
            put("browse_question_bank", new BrowseQuestionBank());
        }
    };

    private static HashMap<String, Command> adminCommands = new HashMap<>() {
        {
            put("login", new Login());
            put("logout", new Logout());
            put("register", new Register());
            put("exit", () -> System.exit(0));

            put("search_user_national_code", new SearchUserByNationalCode());
            put("search_user_email", new SearchUserByEmail());

            put("create_classroom", new CreateClassroom());
            put("browse_classrooms", new BrowseClassrooms());
            put("search_classroom_name", new SearchClassroomByName());
            put("search_classroom_institute", new SearchClassroomByInstitute());
            put("search_classroom_instructor", new SearchClassroomByInstructor());
            put("add_student_to_classroom", new AddStudentToClassroom());
            put("edit_classroom", new EditClassroom());
            put("delete_classroom", new DeleteClassroom());
            put("add_assistant_to_classroom", new AddAssistantToClassroom());
            put("get_classroom_assistants", new GetClassroomAssistants());
            put("remove_assistant_from_classroom", new RemoveAssistantFromClassroom());

            put("add_assignment_to_classroom", new AddAssignmentToClassroom());
            put("get_assignments_of_classroom", new GetAssignmentsOfClassroom());
            put("edit_assignment_of_classroom", new EditAssignment());
            put("delete_assignment_of_classroom", new DeleteAssignmentFromClassroom());
            put("add_question_to_assignment", new AddQuestionToAssignment());
            put("delete_question_from_assignment", new DeleteQuestionFromAssignment());
            put("edit_assignment_question", new EditAssignmentQuestion());
            put("browse_submissions_of_assignment_question", new BrowseSubmissionsOfAssignmentQuestion());
            put("get_final_submission_of_assignment_question", new GetFinalSubmissionForAssignmentQuestion());
            put("set_assignment_score_table_visibility", new SetScoreTableVisibility());
            put("get_score_table_of_assignment", new GetScoreTableOfAssignment());

            put("add_question_to_question_bank", new AddQuestionToQuestionBank());
            put("browse_question_bank", new BrowseQuestionBank());
            put("edit_question_bank_question", new EditQuestion());
            put("browse_submissions_of_question_bank_question", new BrowseSubmissionsOfQuestion());
            put("get_final_submission_of_question_bank_question", new GetFinalSubmissionForAssignmentQuestion());

            put("show_users_table", new ShowUsersTable());
            put("promote_user_to_admin", new PromoteUserToAdmin());

            put("create_competition", new CreateCompetition());
            put("get_owned_competitions", new GetOwnedCompetitions());
            put("delete_owned_competition", new DeleteCompetition());
            put("edit_owned_competition", new EditCompetition());
            put("add_question_to_competition", new AddQuestionToCompetition());
            put("edit_competition_question", new EditCompetitionQuestion());
            put("delete_competition_question", new DeleteQuestionFromCompetition());
        }
    };

    public static HashMap<String, Command> commands = userCommands;

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }

    public static void loadGuestCommands() {
        commands = guestCommands;
    }

    public static void loadUserCommands() {
        commands = userCommands;
    }

    public static void loadAdminCommands() {
        commands = adminCommands;
    }
}
