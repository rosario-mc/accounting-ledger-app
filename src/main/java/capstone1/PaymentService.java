package capstone1;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentService {
    static Scanner scanner = new Scanner(System.in);

    //Payment - user input save to csv
    public static Payment promptForNewPayment() {
        System.out.println("\nPlease Enter Your Name: ");
        String name1 = scanner.nextLine();
        System.out.println("\nEnter The Amount You'd Like To Pay: ");
        BigDecimal paymentAmount = new BigDecimal(scanner.nextLine());
        System.out.println("\nEnter Vendor (Payable To): ");
        String payableToCo = scanner.nextLine();
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
