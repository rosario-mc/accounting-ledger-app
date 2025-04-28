package capstone1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static capstone1.Utils.readAllLines;

public class TransactionServices {
    static Scanner scanner = new Scanner(System.in);

    //All entries
    public static void listAllTransactions(String filename) {
        try {
            List<String> transactions = readAllLines(filename);
            System.out.println("All Transactions (Newest First) :");
            for (int i = transactions.size() - 1; i >= 0; i--) {
                System.out.println(transactions.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File." + e.getMessage() + "\n");
        }
    }

    //All Deposits
    public static void listAllDeposits(String filename) {
        try {
            List<String> deposits = readAllLines(filename);
            System.out.println("Deposits (Newest First):");

            for (int i = deposits.size() - 1; i >= 0; i--) {
                String line = deposits.get(i);

                if (line.contains("Deposit")) {
                    System.out.println(line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    //All Payments
    public static void listAllPayments(String filename) {
        try {
            List<String> payments = readAllLines(filename);
            System.out.println("Payments (Newest First):");

            for (int i = payments.size() - 1; i >= 0; i--) {
                String line = payments.get(i);

                if (line.contains("Payment")) {
                    System.out.println(line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }
}
