package capstone1;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class AccountingLedgerApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Home Screen
        boolean run = true;
        while(run){
            String menu = """
                    Welcome to The Rosario Reserve!
                    What can we do for you today?
                    Please select a transaction from the following options:
                    D- Add A Deposit
                    P- Make A Payment (Debit)
                    L- Ledger
                    E- Exit
                    """;
            System.out.println(menu);
            String choice = scanner.nextLine();
            switch(choice){
                case "D":
                    Deposit newDeposit = promptForNewDeposit();
                    addADeposit("transactions.csv", newDeposit);
                    break;
                case "P":
                    Payment newPayment = promptForNewPayment();
                    addAPayment("transactions.csv" , newPayment);
                    break;
                case "L":
                    ledgerScreenOptions(scanner);
                    break;
                case "E":
                    System.out.println("Thank you for trusting The Rosario Reserve!\nHave a great day!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter one of the options ( D, P, L, E)\n");
                }
            }
        }

    //Deposit - user input and save to csv
    public static Deposit promptForNewDeposit(){
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
    public static Payment promptForNewPayment(){
        System.out.println("Please enter your name: ");
        String name1 = scanner.nextLine();
        System.out.println("Enter the amount you'd like to pay: ");
        BigDecimal paymentAmount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter person/company payable to: ");
        String payableToCo = scanner.nextLine();
        return new Payment(name1, paymentAmount, payableToCo);
    }

    private static void addAPayment(String filename, Payment newPayment){
        try (FileWriter writer = new FileWriter(filename , true)) {
            writer.write(newPayment.toFileString() + "\n");
            System.out.println("Payment recorded successfully!\n");
        } catch(IOException e) {
            System.out.println("An error occurred while writing to the file." + e.getMessage());
        }
    }

    //Ledger - display screen
    public static void ledgerScreenOptions(Scanner scanner){
        boolean run = true;
        while(run){
        String menu = """
                Welcome to your Ledger! Choose one of the following options:
                A- Display All Entries
                D- Display Deposit Entries
                P- Display Payment Entries
                R- Run Reports
                H- Go Back To Home Page
                """;
            System.out.println(menu);
            String ledgerChoice = scanner.nextLine();
            switch(ledgerChoice) {
                case "A":
                    break;
                case "D":
                    break;
                case "P":
                    break;
                case "R":
                    break;
                case "H":
                    run = false;
                    break;
            }
        }
    }


    //Ledger Screen

    //All entries

    //Deposits

    //Payments - only negative entries(payments)

    //Reports - display screen

    //Reports Screen

    //Month to Date

    //Prev Month

    //Year to Date

    //Prev Year

    //Search by Vendor

    //Back to Report Page

    //Home



    }

