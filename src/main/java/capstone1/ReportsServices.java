package capstone1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static capstone1.Utils.printReportInDateRange;
import static capstone1.Utils.readAllLines;


public class ReportsServices {
    static Scanner scanner = new Scanner(System.in);

    //Print Month To Date
    public static void monthToDateReport(String filename) {
        LocalDate today = LocalDate.now();
        LocalDate start = today.withDayOfMonth(1);
        printReportInDateRange(filename, "Month To Date", start, today);
    }

    //Print Prev Month
    public static void previousMonthReport(String filename) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayLastMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate lastDayLastMonth = today.withDayOfMonth(1).minusDays(1);
        printReportInDateRange(filename, "Previous Month", firstDayLastMonth, lastDayLastMonth);
    }

    //Print Year To Date
    public static void yearToDateReport(String filename) {
        LocalDate today = LocalDate.now();
        LocalDate start = today.withDayOfYear(1);
        printReportInDateRange(filename, "Year To Date", start, today);
    }

    //Print Prev Year
    public static void previousYearReport(String filename) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayLastYear = LocalDate.of(today.getYear() - 1, 1, 1);
        LocalDate lastDayLastYear = LocalDate.of(today.getYear() - 1, 12, 31);
        printReportInDateRange(filename, "Previous Year", firstDayLastYear, lastDayLastYear);
    }

    //Search By Vendor & Print
    public static void searchByVendor(String filename) {
        try {
            System.out.println("\nEnter Vendor Name:\n");
            String vendorName = scanner.nextLine().trim().toUpperCase();
            if (!vendorName.matches("[A-Z ]+")) {
                System.out.println("\nVendor Name Must Only Contain Letters And Spaces.");
                return;
            }

            if (vendorName.isEmpty()) {
                System.out.println("\nVendor Name Cannot Be Blank.");
                return;
            }

            List<String> lines = readAllLines(filename);
            System.out.println("\n===========================================================\nAll " + vendorName + " Reports:\n");

            boolean found = false;
            for (int i = lines.size() - 1; i >= 0; i--) {
                String line = lines.get(i);
                if (line.toUpperCase().contains(vendorName)) {
                    System.out.println(line + "\n");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("\nNo Records Found For Vendor: " + vendorName + "\n");
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred While Accessing File: " + e.getMessage() + "\n");
        }
    }
}

