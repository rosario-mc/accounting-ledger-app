package capstone1;

import java.util.Scanner;

public class MenuService {
    static Scanner scanner = new Scanner(System.in);

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
                    Deposit newDeposit = DepositService.promptForNewDeposit();
                    DepositService.addADeposit("src/main/resources/transactions.csv", newDeposit);
                    break;
                case "P", "PAYMENT", "DEBIT", "MAKE A PAYMENT", "MAKE A PAYMENT DEBIT", "MAKE A PAYMENT (DEBIT)",
                     "DEBIT PAYMENT", "PAYMENT DEBIT":
                    Payment newPayment = PaymentService.promptForNewPayment();
                    PaymentService.addAPayment("src/main/resources/transactions.csv", newPayment);
                    break;
                case "L", "LEDGER":
                    ledgerScreenOptions();
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
    public static void ledgerScreenOptions() {

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
                    TransactionServices.listAllTransactions("src/main/resources/transactions.csv");
                    break;
                case "D", "DEPOSIT ENTRIES", "DEPOSIT":
                    TransactionServices.listAllDeposits("src/main/resources/transactions.csv");
                    break;
                case "P", "PAYMENT ENTRIES", "PAYMENT":
                    TransactionServices.listAllPayments("src/main/resources/transactions.csv");
                    break;
                case "R", "RUN REPORTS", "REPORTS", "RUN":
                    reportsScreenOption();
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
    public static void reportsScreenOption() {

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
                    6. Custom Search
                    0. Back To Ledger Screen
                    """;
            System.out.println(menu);
            int reportChoice = Integer.parseInt(scanner.nextLine());
            switch (reportChoice) {
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
                case 6:
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter one of the options (0, 1, 2, 3, 4, 5):\n");
            }
        }
    }
}
