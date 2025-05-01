# Accounting Ledger CLI Application 

Hi there! I'm Rosario, and this project is really special to me — it's my **very first full Java application**. I created this Accounting Ledger as part of my Capstone 1 project for the Java Development Fundamentals course, and I’m proud to say it is complete and working!

This is a simple but powerful **Command Line Interface (CLI)** tool that keeps track of deposits and payments — perfect for personal budgeting or small business bookkeeping. It reads and writes to a `.csv` file so your data sticks with you.

---

## What It Does

From the Home Screen, you can:

- **Add Deposits** 
- **Make Payments**
- **View the Ledger Screen Option** 
- **Exit** 

From the Ledger Screen, you can:
- **View All Transactions** 
- **View All Deposit Transactions**
- **View All Payment Transactions**
- **View Run Reports Screen Option** 
- **Go Back To Home Page**

From the Run Reports Screen, you can:
- **View All Transactions From Month-To-Date**
- **View All Transactions From Previous Month**
- **View All Transactions From Year To Date**
- **View All Transactions From Previous Year**
- **View All Transactions From Search By Vendor**
- **Go Back To Ledger Screen**

## Technologies Used
- Java
- Command Line Interface (CLI)
- CSV file for storage
- IntelliJ

## Application Basic Demo

![Screen Recording 2025-04-30 192119](https://github.com/user-attachments/assets/e9c765d9-d463-4a54-9af3-02aeb38b9838)


## A Cool Piece of My Code
```java
package capstone1;

public class AccountingLedgerApp {

    public static void main(String[] args) {
        MenuService.displayHomeScreen();
    }
}
```
I learned a lot throughout this project, and I can successfully keep my main clean and concise. This is one of my favorite features of this whole project!

## Final Thoughts
This project marks the start of my journey into tech, and I hope it inspires someone else just starting out, too. Thanks for checking out my work — and if you have feedback or suggestions, I’d love to hear them!
