package capstone1;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
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

    public static int safeIntegerInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
    }

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
