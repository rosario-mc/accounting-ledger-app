package capstone1;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    //For Numbers in Name
    public static String promptValidName(Scanner scanner, String message) {
        String name;

        while (true) {
            name = promptNonEmptyString(scanner, message);
            if (name.matches("[a-zA-Z ]+")) {
                return name; // valid input
            } else {
                System.out.println("\nInvalid Name. Please Enter Letters Only.\n");
            }
        }
    }

    //For Blank User Input
    public static String promptNonEmptyString(Scanner scanner, String promptMessage) {
        String input;
        do {
            System.out.println(promptMessage);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("\nCannot Be Blank. Please Try Again.\n");
            }
        } while (input.isEmpty());
        return input;
    }

    //For Transaction Services (Try/Catch Method)
    public static void printFilteredTransactions(String filename, String header, String filterKeyword) {
        try {
            List<String> lines = readAllLines(filename);
            System.out.println("=======================================================\n" + header + " (Newest First):\n");

            for (int i = lines.size() - 1; i >= 0; i--) {
                String line = lines.get(i);

                if (filterKeyword == null || line.contains(filterKeyword)) {
                    System.out.println(line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    //For Report Services (Try/Catch Method)
    public static void printReportInDateRange(String filename, String header, LocalDate start, LocalDate end) {
        try {
            System.out.println("=======================================================\n" + header + ":\n");
            List<String> lines = readAllLines(filename);

            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length > 0) {
                    String datePart = parts[0].trim();
                    LocalDate transactionDate = LocalDate.parse(datePart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    if ((transactionDate.isEqual(start) || transactionDate.isAfter(start)) &&
                            (transactionDate.isEqual(end) || transactionDate.isBefore(end))) {
                        System.out.println(line + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    //To Read Transactions In Csv File
    public static List<String> readAllLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    //For Run Reports Screen Display
    public static int safeIntegerInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter your choice:\n");
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid Option. Please Enter One Of The Following Options (0, 1, 2, 3, 4, 5):\n");
            }
        }
    }

    //For Amount Input
    public static BigDecimal promptPositiveBigDecimal(Scanner scanner, String promptMessage) {
        BigDecimal amount;
        do {
            System.out.println(promptMessage);
            amount = safeBigDecimalInput(scanner);
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Amount Must Be Greater Than Zero. Please Try Again.");
            }
        } while (amount.compareTo(BigDecimal.ZERO) <= 0);
        return amount;
    }

    //For ^
    public static BigDecimal safeBigDecimalInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid Input. Please Enter a Valid Number:");
            }
        }
    }
}
