# Accounting Ledger CLI Application 

Hi there! I'm Rosario, and this project is really special to me — it's my **very first full Java application**. I created this Accounting Ledger as part of my Capstone 1 project for Year Up United, and I’m proud to say it works!

This is a simple but powerful **Command Line Interface (CLI)** tool that keeps track of deposits and payments — perfect for personal budgeting or small business bookkeeping. It reads and writes to a `.csv` file so your data sticks with you.

---

## What It Does

From the Home Screen, you can:

- **Add Deposits** – Enter the vendor, and amount
- **Make Payments** – Record expenses or other debits
- **View the Ledger** – See all transactions sorted by newest first
- **Generate Reports** – Quickly view Month-to-Date, Year-to-Date, or even search by vendor
- **Exit** – Close the program

## Technologies Used
- Java
- Command Line Interface (CLI)
- CSV file for storage

## Application Basic Demo
![Screen Recording 2025-04-29 142428](https://github.com/user-attachments/assets/d6df726a-3260-47ff-98da-1de68ac7dcfd)


## A Cool Piece of My Code
```java
package capstone1;

public class AccountingLedgerApp {

    public static void main(String[] args) {
        MenuService.displayHomeScreen();
    }
}
```

This is the first time I have been able to have my main this clean and readable. Throughout this Capstone I learned a lot of new things, and this is personally one of my favorite aspects of my code! 


## Final Thoughts
This project marks the start of my journey into tech, and I hope it inspires someone else just starting out, too. Thanks for checking out my work — and if you have feedback or suggestions, I’d love to hear them!
