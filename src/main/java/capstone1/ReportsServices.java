package capstone1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static capstone1.Utils.readAllLines;


public class ReportsServices {
    static Scanner scanner = new Scanner(System.in);

    public static void monthToDateReport(String filename) {
        try {
            System.out.println("Month To Date: ");
            List<String> lines = readAllLines(filename);
            LocalDate today = LocalDate.now();

            for (String line: lines) {
                String[] parts = line.split("\\|");
                if (parts.length > 0) {
                    String datePart = parts[0].trim();
                    LocalDate transactionDate = LocalDate.parse(datePart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (transactionDate.getMonth() == today.getMonth() && transactionDate.getYear() == today.getYear()) {
                        System.out.println(line + "\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    public static void previousMonthReport(String filename) {
        try {
            System.out.println("Previous Month Reports: ");
            List<String> lines = readAllLines(filename);

            LocalDate today = LocalDate.now();
            LocalDate lastMonth = today.minusMonths(1);

            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length > 0) {
                    String datePart = parts[0].trim();
                    LocalDate transactionDate = LocalDate.parse(datePart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (transactionDate.getMonth() == lastMonth.getMonth() &&
                            transactionDate.getYear() == lastMonth.getYear()) {
                        System.out.println(line + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    public static void yearToDateReport(String filename) {
        try {
            System.out.println("Year To Date: ");
            List<String> lines = readAllLines(filename);

            LocalDate today = LocalDate.now();

            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length > 0) {
                    String datePart = parts[0].trim();
                    LocalDate transactionDate = LocalDate.parse(datePart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (transactionDate.getYear() == today.getYear()) {
                        System.out.println(line + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    public static void previousYearReport(String filename) {
        try {
            System.out.println("Previous Year Reports: ");
            List<String> lines = readAllLines(filename);

            LocalDate today = LocalDate.now();
            int lastYear = today.getYear() - 1;

            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length > 0) {
                    String datePart = parts[0].trim();
                    LocalDate transactionDate = LocalDate.parse(datePart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    if (transactionDate.getYear() == lastYear) {
                        System.out.println(line + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }

    public static void searchByVendor(String filename) {
        try {
            System.out.println("Enter vendor name to search: ");
            String vendorName = scanner.nextLine().toUpperCase();

            List<String> lines = readAllLines(filename);

            for (int i = lines.size() - 1; i >= 0; i--) {
                String line = lines.get(i);

                if (line.toUpperCase().contains(vendorName)) {
                    System.out.println(line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }
}

