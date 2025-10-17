package com.pluralsight;

public class Transcation {
    public static class Transaction {
        private String date;
        private String time;
        private String description;
        private String vendor;
        private double amount;

        // constructor
        public Transaction(String date, String time, String description, String vendor, double amount) {
            this.date = date;
            this.time = time;
            this.description = description;
            this.vendor = vendor;
            this.amount = amount;
        }

        // getters
        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public String getDescription() {
            return description;
        }

        public String getVendor() {
            return vendor;
        }

        public double getAmount() {
            return amount;
        }

        // display transaction
        public void display() {
            System.out.printf("%-10s | %-8s | %-18s | %-18s | $%.2f\n",
                    date, time, description, vendor, amount);
        }
    }
}
