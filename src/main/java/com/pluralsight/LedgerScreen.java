package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class LedgerScreen {
    private Scanner scanner;

    public LedgerScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    // Create ledger menu
    public void show() {
        boolean running = true;
        //Loop through ledger menu and output menu option based on users input
        while (running) {
            System.out.println("\n====== LEDGER MENU ======");
            System.out.println("A) All entries");
            System.out.println("D) Deposits only");
            System.out.println("P) Payments only");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("=========================");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    displayAll();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    ReportsScreen reports = new ReportsScreen(scanner);
                    reports.show();
                    break;
                case "H":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    // display all entries
    private void displayAll() {
        System.out.println("\n--- All Entries (Newest First) ---");
        System.out.println("Date       | Time     | Description        | Vendor             | Amount");
        System.out.println("-------------------------------------------------------------------------------");

        ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            transactions.get(i).display();
        }
    }

    // display deposits only
    private void displayDeposits() {
        System.out.println("\n--- Deposits Only ---");
        System.out.println("Date       | Time     | Description        | Vendor             | Amount");
        System.out.println("-------------------------------------------------------------------------------");

        ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transcation.Transaction t = transactions.get(i);
            if (t.getAmount() > 0) {
                t.display();
            }
        }
    }

    // display payments only
    private void displayPayments() {
        System.out.println("\n--- Payments Only ---");
        System.out.println("Date       | Time     | Description        | Vendor             | Amount");
        System.out.println("-------------------------------------------------------------------------------");

        ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transcation.Transaction t = transactions.get(i);
            if (t.getAmount() < 0) {
                t.display();
            }
        }
    }
}
