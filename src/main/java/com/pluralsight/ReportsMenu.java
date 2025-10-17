package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public static void ReportsScreen(Scanner scanner) {
    this.scanner = scanner;
}

// show reports menu

public void show() {
    boolean running = true;

    while (running) {
        System.out.println("\n====== REPORTS ======");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back");
        System.out.println("=====================");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                monthToDate();
                break;
            case "2":
                previousMonth();
                break;
            case "3":
                yearToDate();
                break;
            case "4":
                previousYear();
                break;
            case "5":
                searchByVendor();
                break;
            case "0":
                running = false;
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}

// month to date report
private void monthToDate() {
    System.out.println("\n--- Month To Date ---");
    printHeader();

    LocalDate now = LocalDate.now();
    int currentMonth = now.getMonthValue();
    int currentYear = now.getYear();

    ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

    for (Transcation.Transaction t : transactions) {
        LocalDate transDate = LocalDate.parse(t.getDate());
        if (transDate.getMonthValue() == currentMonth && transDate.getYear() == currentYear) {
            t.display();
        }
    }
}

// previous month report
private void previousMonth() {
    System.out.println("\n--- Previous Month ---");
    printHeader();

    LocalDate prev = LocalDate.now().minusMonths(1);
    int prevMonth = prev.getMonthValue();
    int prevYear = prev.getYear();

    ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

    for (Transcation.Transaction t : transactions) {
        LocalDate transDate = LocalDate.parse(t.getDate());
        if (transDate.getMonthValue() == prevMonth && transDate.getYear() == prevYear) {
            t.display();
        }
    }
}

// year to date report
private void yearToDate() {
    System.out.println("\n--- Year To Date ---");
    printHeader();

    int currentYear = LocalDate.now().getYear();
    ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

    for (Transcation.Transaction t : transactions) {
        LocalDate transDate = LocalDate.parse(t.getDate());
        if (transDate.getYear() == currentYear) {
            t.display();
        }
    }
}

// previous year report
private void previousYear() {
    System.out.println("\n--- Previous Year ---");
    printHeader();

    int prevYear = LocalDate.now().getYear() - 1;
    ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();

    for (Transcation.Transaction t : transactions) {
        LocalDate transDate = LocalDate.parse(t.getDate());
        if (transDate.getYear() == prevYear) {
            t.display();
        }
    }
}

// search by vendor
private void searchByVendor() {
    System.out.print("\nEnter vendor name: ");
    String vendorName = scanner.nextLine();

    System.out.println("\n--- Transactions for: " + vendorName + " ---");
    printHeader();

    ArrayList<Transcation.Transaction> transactions = FileManager.readTransactions();
    boolean found = false;

    for (Transcation.Transaction t : transactions) {
        if (t.getVendor().equalsIgnoreCase(vendorName)) {
            t.display();
            found = true;
        }
    }

    if (!found) {
        System.out.println("No transactions found for this vendor.");
    }
}

// helper method to print table header
private void printHeader() {
    System.out.println("Date       | Time     | Description        | Vendor             | Amount");
    System.out.println("-------------------------------------------------------------------------------");
}
}