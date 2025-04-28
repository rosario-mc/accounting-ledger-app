package capstone1;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentService {
    static Scanner scanner = new Scanner(System.in);

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
}
