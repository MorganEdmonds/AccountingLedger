package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // create HOME MENU
        // ask user for debit information


        String HomeMenu = """
                ----HOME.MENU-----
                D- Add Deposit
                P- Make payment
                L- Ledger Screen
                X- Exit   
                
                """;//

        System.out.print("Add Deposit");
        System.out.print("Make payment");
        System.out.print("Ledger Screen");
        System.out.print("Exit");
    }

}
                
                
