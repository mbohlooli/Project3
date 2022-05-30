package ir.ac.kntu.core;

import ir.ac.kntu.commands.Commands;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void listen() {
        while (true) {
            System.out.print(">>> ");
            Commands.getCommand(scanner.nextLine()).execute();
        }
    }

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static String nextLine(String pattern) {
        //TODO: make this ask for input again
        String result = scanner.nextLine();
        if (!result.matches(pattern)) {
            throw new IllegalStateException("Invalid format.");
        }
        return result;
    }

    public static int nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static boolean nextBoolean() {
        return scanner.nextLine().equals("y");
    }
}
