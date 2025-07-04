package com.secureapp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String user = scanner.nextLine();
                System.out.print("Enter password: ");
                String pass = scanner.nextLine();
                if (authService.register(user, pass)) {
                    System.out.println("✅ Registration successful!");
                } else {
                    System.out.println("❌ Registration failed.");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String user = scanner.nextLine();
                System.out.print("Enter password: ");
                String pass = scanner.nextLine();
                if (authService.login(user, pass)) {
                    System.out.println("✅ Login successful! Welcome " + user);
                } else {
                    System.out.println("❌ Invalid credentials.");
                }
            } else {
                break;
            }
        }

        scanner.close();
    }
}
