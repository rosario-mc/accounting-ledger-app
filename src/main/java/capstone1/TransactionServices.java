package capstone1;

public class TransactionServices {

    //All Transactions
    public static void listAllTransactions(String filename) {
        Utils.printFilteredTransactions(filename, "All Transactions", null);
    }

    //All Deposits Transactions
    public static void listAllDeposits(String filename) {
        Utils.printFilteredTransactions(filename, "Deposits", "Deposit");
    }

    //All Payments Transactions
    public static void listAllPayments(String filename) {
        Utils.printFilteredTransactions(filename, "Payments", "Payment");
    }
}