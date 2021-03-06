package ir.ac.kntu.models.question;

import ir.ac.kntu.core.Auth;
import ir.ac.kntu.core.Console;
import ir.ac.kntu.models.Submission;
import ir.ac.kntu.models.SubmissionPack;
import ir.ac.kntu.models.user.User;

import java.util.*;

public abstract class Question {
    protected String name;

    protected int maxScore;

    protected String description;

    protected User owner;

    protected Date createdAt;

    protected Difficulty difficulty;

    protected Map<User, SubmissionPack> submissionPacks;

    public Question(String name, int maxScore, String description, Difficulty difficulty) {
        this.name = name;
        this.maxScore = maxScore;
        this.description = description;
        this.difficulty = difficulty;
        owner = Auth.getCurrentUser();
        createdAt = new Date();
        submissionPacks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void submitAnswer(Submission submission) {
        ArrayList<Submission> submissions = submissionPacks.get(Auth.getCurrentUser()).getSubmissions();
        if (submissions == null) {
            submissionPacks.put(Auth.getCurrentUser(), new SubmissionPack(this));
        }
        submission.setFinal(true);
        if (submissions.size() != 0) {
            submissions.get(submissions.size()-1).setFinal(false);
        }
        submissionPacks.get(Auth.getCurrentUser()).addSubmission(submission);
    }

    public User getOwner() {
        return owner;
    }

    public void edit() {
        System.out.print("name: ");
        String name = Console.nextLine();
        if (!name.equals("")) {
            this.name = name;
        }
        System.out.print("max score: ");
        String maxScore = Console.nextLine();
        if(!maxScore.equals("")) {
            this.maxScore = Integer.parseInt(maxScore);
        }
        System.out.print("description: ");
        String description = Console.nextLine();
        if(!description.equals("")) {
            this.description = description;
        }
        System.out.println("Change difficulty(y/n)? ");
        boolean change = Console.nextBoolean();
        if (change) {
            this.difficulty = Console.nextDifficulty();
        }
    }

    public SubmissionPack getSubmissions(User user) {
        return submissionPacks.get(user);
    }

    public List<User> getUsers() {
        return submissionPacks.keySet().stream().toList();
    }

    @Override
    public String toString() {
        return name + "\n" + description;
    }

    protected SubmissionPack getOrCreateSubmissionPack() {
        if (!submissionPacks.containsKey(Auth.getCurrentUser())) {
            submissionPacks.put(Auth.getCurrentUser(), new SubmissionPack(this));
        }

        return submissionPacks.get(Auth.getCurrentUser());
    }
}
