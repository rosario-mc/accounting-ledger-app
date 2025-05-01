package capstone1;

import java.util.Scanner;

public class TransactionServices {
    static Scanner scanner = new Scanner(System.in);

    //All entries
    public static void listAllTransactions(String filename) {
        Utils.printFilteredTransactions(filename, "All Transactions", null);
    }

    //All Deposits
    public static void listAllDeposits(String filename) {
        Utils.printFilteredTransactions(filename, "Deposits", "Deposit");
    }

    //All Payments
    public static void listAllPayments(String filename) {
        Utils.printFilteredTransactions(filename, "Payments", "Payment");
    }
}