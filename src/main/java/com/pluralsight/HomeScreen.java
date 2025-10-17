package com.pluralsight;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public HomeScreen(Scanner scanner) {
    this.scanner = scanner;
}

import java.util.Scanner;


// create HOME MENU
public void show() {
    boolean running = true;

    //Loop through home menu and output menu option based on users input
    while (running) {
        System.out.println("\n====== HOME MENU ======");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.println("=======================");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "D":
                addDeposit();
                break;
            case "P":
                makePayment();
                break;
            case "L":
                LedgerScreen ledger = new LedgerScreen(scanner);
                ledger.show();
                break;
            case "X":
                System.out.println("Exiting application...");
                running = false;
                break;
            default:
                System.out.println("Invalid option. Try again.");
                break;
        }
    }
}

// add deposit
private void addDeposit() {
    System.out.println("\n--- Add Deposit ---");

    System.out.print("Enter description: ");
    String description = scanner.nextLine();

    System.out.print("Enter vendor: ");
    String vendor = scanner.nextLine();

    System.out.print("Enter amount: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();

    String date = LocalDate.now().toString();
    String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    Transcation.Transaction transaction = new Transcation.Transaction(date, time, description, vendor, amount);
    FileManager.writeTransaction(transaction);

    System.out.println("Deposit added successfully!");
}

// make payment
private void makePayment() {
    System.out.println("\n--- Make Payment ---");

    System.out.print("Enter description: ");
    String description = scanner.nextLine();

    System.out.print("Enter vendor: ");
    String vendor = scanner.nextLine();

    System.out.print("Enter amount: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();

    String date = LocalDate.now().toString();
    String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    Transcation.Transaction transaction = new Transcation.Transaction(date, time, description, vendor, -amount);
    FileManager.writeTransaction(transaction);

    System.out.println("Payment recorded successfully!");
}
}
