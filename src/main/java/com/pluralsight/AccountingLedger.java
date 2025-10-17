package com.pluralsight;

import java.util.Scanner;

public class AccountingLedger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HomeScreen homeScreen = new HomeScreen(scanner);
        homeScreen.show();

        scanner.close();
    }
}
