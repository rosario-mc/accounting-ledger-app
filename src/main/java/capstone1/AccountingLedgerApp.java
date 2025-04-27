package capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountingLedgerApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayHomeScreen();

    }


    //Home Screen
    public static void displayHomeScreen() {
        boolean run = true;
        while (run) {
            String menu = """
                    Welcome to THE ROSARIO RESERVE!
                    What can we do for you today?
                    Please select a transaction from the following options:
                    D- Add A Deposit
                    P- Make A Payment (Debit)
                    L- Ledger
                    E- Exit
                    """;
            System.out.println(menu);
            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "D", "DEPOSIT", "ADD A DEPOSIT":
                    Deposit newDeposit = promptForNewDeposit();
                    addADeposit("transactions.csv", newDeposit);
                    break;
                case "P", "PAYMENT", "DEBIT", "MAKE A PAYMENT", "MAKE A PAYMENT DEBIT", "MAKE A PAYMENT (DEBIT)",
                     "DEBIT PAYMENT", "PAYMENT DEBIT":
                    Payment newPayment = promptForNewPayment();
                    addAPayment("transactions.csv", newPayment);
                    break;
                case "L", "LEDGER":
                    ledgerScreenOptions(scanner);
                    break;
                case "E", "EXIT":
                    System.out.println("Thank you for trusting THE ROSARIO RESERVE!\nHave a great day!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter one of the options:\n");
            }
        }
    }


    //Ledger - display screen
    public static void ledgerScreenOptions(Scanner scanner) {
        boolean run = true;
        while (run) {
            String menu = """
                    LEDGER
                    Please choose one of the following options to display:
                    A- All Entries
                    D- Deposit Entries
                    P- Payment Entries
                    R- Run Reports
                    H- Home Page
                    """;
            System.out.println(menu);
            String ledgerChoice = scanner.nextLine().toUpperCase();
            switch (ledgerChoice) {
                case "A", "ALL ENTRIES", "ALL":
                    listAllTransactions("transactions.csv");
                    break;
                case "D", "DEPOSIT ENTRIES", "DEPOSIT":
                    listAllDeposits("transactions.csv");
                    break;
                case "P", "PAYMENT ENTRIES", "PAYMENT":
                    listAllPayments("transactions.csv");
                    break;
                case "R", "RUN REPORTS", "REPORTS", "RUN":
                    reportsScreenOption(scanner);
                    break;
                case "H", "HOME", "HOME PAGE":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter one of the options:\n");
            }
        }
    }

    //Reports - display screen
    public static void reportsScreenOption(Scanner scanner){
        boolean run = true;
        while (run) {
            String menu = """
                    REPORTS
                    Please choose one of the following options to run a report:
                    1. Month To Date
                    2. Previous Month
                    3. Year To Date
                    4. Previous Year
                    5. Search By Vendor
                    0. Back To Ledger Screen
                    """;
            System.out.println(menu);
            int reportChoice = scanner.nextInt();
            switch (reportChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter one of the options (0, 1, 2, 3, 4, 5):\n");
            }
        }
    }


    //Deposit - user input and save to csv
    public static Deposit promptForNewDeposit() {
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("How much would you like to deposit?: ");
        BigDecimal depositAmount = new BigDecimal(scanner.nextLine());
        return new Deposit(name, depositAmount);
    }

    public static void addADeposit(String filename, Deposit newDeposit) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(newDeposit.toFileString() + "\n");
            System.out.println("Deposit recorded successfully!\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file." + e.getMessage());
        }
    }


    //Payment - user input save to csv
    public static Payment promptForNewPayment() {
        System.out.println("Please enter your name: ");
        String name1 = scanner.nextLine();
        System.out.println("Enter the amount you'd like to pay: ");
        BigDecimal paymentAmount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter person/company payable to: ");
        String payableToCo = scanner.nextLine();
        return new Payment(name1, paymentAmount, payableToCo);
    }

    public static void addAPayment(String filename, Payment newPayment) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(newPayment.toFileString() + "\n");
            System.out.println("Payment recorded successfully!\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file." + e.getMessage() + "\n");
        }
    }


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


    //Month to Date


    //Prev Month


    //Year to Date


    //Prev Year


    //Search by Vendor


    //Back to Report Page


    //Home

}