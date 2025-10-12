package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // create HOME MENU
        // ask user for debit information
        //Loop through home menu and output menu option based on users input


        String HomeMenu = """
                ----HOME.MENU-----
                D- Add Deposit
                P- Make payment
                L- Ledger Screen
                X- Exit   
                
                """;//

        System.out.println(HomeMenu);




        System.out.print("Please enter a option: ");
        String choice = scanner.nextLine().toUpperCase();

        switch (choice){

            case 
        }

        //System.out.print("Add Deposit");
        //System.out.print("Make payment");
        //System.out.print("Ledger Screen");
        //System.out.print("Exit");
    }
}


