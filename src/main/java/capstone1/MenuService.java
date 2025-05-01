package capstone1;

import java.util.Scanner;

public class MenuService {
    static Scanner scanner = new Scanner(System.in);

    //Home Screen
    public static void displayHomeScreen() {

        boolean run = true;
        while (run) {
            String menu = """
                                 Welcome To THE ROSARIO RESERVE!
                                  What Can We Do For You Today?
                    ===========================================================
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
                    System.out.println("===========================================================\n\nThank you for trusting THE ROSARIO RESERVE!\n\nHave a great day!");
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
                    ===========================================================
                    Please Choose One Of The Following Options To Display:
                    
                    A- All Transactions
                    
                    D- Deposit Transactions
                    
                    P- Payment Transactions
                    
                    R- Run Reports
                    
                    H- Home Page
                    """;
            System.out.println(menu);
            String ledgerChoice = scanner.nextLine().toUpperCase();
            switch (ledgerChoice) {
                case "A", "ALL TRANSACTIONS", "ALL":
                    TransactionServices.listAllTransactions("src/main/resources/transactions.csv");
                    break;
                case "D", "DEPOSIT TRANSACTIONS", "DEPOSIT":
                    TransactionServices.listAllDeposits("src/main/resources/transactions.csv");
                    break;
                case "P", "PAYMENT TRANSACTIONS", "PAYMENT":
                    TransactionServices.listAllPayments("src/main/resources/transactions.csv");
                    break;
                case "R", "RUN REPORTS", "REPORTS", "RUN":
                    reportsScreenOption();
                    break;
                case "H", "HOME", "HOME PAGE":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Option. Please Enter One Of The Options:\n");
            }
        }
    }

    //Reports - display screen
    public static void reportsScreenOption() {

        boolean run = true;
        while (run) {
            String menu = """
                                           REPORTS
                    ===========================================================
                    Please choose one of the following options to run a report:
                    
                    1. Month To Date
                    
                    2. Previous Month
                    
                    3. Year To Date
                    
                    4. Previous Year
                    
                    5. Search By Vendor
                    
                    0. Back To Ledger Screen
                    """;

            System.out.println(menu);

            int reportChoice = Utils.safeIntegerInput(scanner);

            switch (reportChoice) {
                case 1:
                    ReportsServices.monthToDateReport("src/main/resources/transactions.csv");
                    break;
                case 2:
                    ReportsServices.previousMonthReport("src/main/resources/transactions.csv");
                    break;
                case 3:
                    ReportsServices.yearToDateReport("src/main/resources/transactions.csv");
                    break;
                case 4:
                    ReportsServices.previousYearReport("src/main/resources/transactions.csv");
                    break;
                case 5:
                    ReportsServices.searchByVendor("src/main/resources/transactions.csv");
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Option. Please Enter One Of The Following Options (0, 1, 2, 3, 4, 5):\n");

            }
        }
    }
}
