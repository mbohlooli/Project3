package ir.ac.kntu.core;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void listen() {
        while (true) {
            System.out.print(">>> ");
            System.out.println(scanner.nextLine());
        }
    }
}
