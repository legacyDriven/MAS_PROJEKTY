package org.example;

import java.util.Scanner;

public class UserInterface {

    private UserInterface() {
        throw new AssertionError("Cannot create instance of utility class");
    }

    public static void unitUI() {

        boolean exit = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!exit) {
                System.out.println("Menu:");
                System.out.println("1. Generate and save person in local cache");
                System.out.println("2. Show persons stored in local cache - basic view");
                System.out.println("3. Show persons stored in local cache - detailed view");
                System.out.println("4. Serialize persons stored in local cache");
                System.out.println("5. Deserialize persons from file to local cache");
                System.out.println("6. Clear local cache");
                System.out.println("7. Exit program");

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> Utils.generatePerson();
                        case 2 -> Utils.showPersonsBasicInfoFromLocalCache();
                        case 3 -> Utils.showPersonsDetailedInfoFromLocalCache();
                        case 4 -> Utils.serializePersonsFromLocalCache();
                        case 5 -> Utils.deserializePersons();
                        case 6 -> Utils.clearLocalCache();
                        case 7 -> exit = true;
                        default -> System.out.println("Invalid argument, please retry.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred, please retry");
                    scanner.nextLine(); // aby uniknąć nieskończonej pętli w przypadku błędu
                }
            }
        }
    }
}



