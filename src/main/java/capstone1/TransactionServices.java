package capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionServices {
    static Scanner scanner = new Scanner(System.in);

    //All entries
    public static void listAllTransactions(String filename) {
        List<String> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
            System.out.println("All Transactions (Newest First) :");
            for (int i = transactions.size() - 1; i >= 0; i--) {
                System.out.println(transactions.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while accessing file." + e.getMessage() + "\n");
        }
    }

    //All Deposits
    public static void listAllDeposits(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Deposits (Newest First):");

            List<String> transactions = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }

            for (int i = transactions.size() - 1; i >= 0; i--) {
                line = transactions.get(i);

                if (line.contains("Deposit")) {
                    System.out.println(line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while accessing file: " + e.getMessage() + "\n");
        }
    }

    //All Payments
    public static void listAllPayments(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Payments (Newest First):");

            List<String> transactions = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }

            for (int i = transactions.size() - 1; i >= 0; i--) {
                line = transactions.get(i);

                if (line.contains("Payment")) {
                    System.out.println(line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while accessing file: " + e.getMessage() + "\n");
        }
    }
}
