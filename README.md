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

From the Ledger Screen, you can view:
- **All Transactions** 
- **All Deposit Transactions**
- **All Payment Transactions**
- **Run Reports Screen Option** 
- **Go Back To Home Page**

From the Run Reports Screen, you can view all transactions from:
- **Month-To-Date**
- **Previous Month**
- **To Date**
- **Previous Year**
- **Search By Vendor**
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
>*This snippet launches the application by calling a separate service to handle the menu — keeping the `main` method focused and clutter-free.*
> 
This is one of my favorite parts of the project because it shows how I kept the main method clean and concise. I learned a lot about organizing my code, separating responsibilities, and keeping logic modular.

## Acknowledgments
Thank you to my instructor, Maaike, for always being supportive and resourceful! A special shout out to all my peers that have helped me throughout these past couple of weeks. You guys are the best!!!

## Final Thoughts
This project marks the start of my journey into tech, and I hope it inspires someone else just starting out, too. Thanks for checking out my work — and if you have feedback or suggestions, I’d love to hear them!
