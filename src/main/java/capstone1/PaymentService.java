package capstone1;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentService {
    static Scanner scanner = new Scanner(System.in);

    //Payment - user input & save to csv
    public static Payment promptForNewPayment() {
        String name1 = Utils.promptNonEmptyString(scanner, "\nPlease Enter Your Name:");
        BigDecimal paymentAmount = Utils.promptPositiveBigDecimal(scanner, "\nEnter The Amount You'd Like To Pay:");
        String payableToCo = Utils.promptNonEmptyString(scanner, "\nEnter Vendor (Payable To):");

        return new Payment(name1, paymentAmount, payableToCo);
    }

    public static void addAPayment(String filename, Payment newPayment) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(newPayment.toFileString() + "\n");
            System.out.println("\nPayment Recorded Successfully!\n\n\n");
        } catch (IOException e) {
            System.out.println("An Error Occurred While Writing To The File!" + e.getMessage() + "\n");
        }
    }
}
