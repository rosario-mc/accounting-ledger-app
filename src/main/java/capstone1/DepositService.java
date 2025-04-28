package capstone1;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class DepositService {
    static Scanner scanner = new Scanner(System.in);

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
}
