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
}
