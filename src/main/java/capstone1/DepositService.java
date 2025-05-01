package capstone1;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class DepositService {
    static Scanner scanner = new Scanner(System.in);

    //Deposit - user input and save to csv
    public static Deposit promptForNewDeposit() {
        String name = Utils.promptNonEmptyString(scanner, "\nPlease enter your name:");
        BigDecimal depositAmount = Utils.promptPositiveBigDecimal(scanner, "\nHow Much Would You Like To Deposit?:");
        return new Deposit(name, depositAmount);
    }

    public static void addADeposit(String filename, Deposit newDeposit) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(newDeposit.toFileString() + "\n");
            System.out.println("\nDeposit Recorded Successfully!\n\n\n");
        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage());
        }
    }
}
