package capstone1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deposit {
    private String name;
    private BigDecimal depositAmount;

   public Deposit(String name, BigDecimal depositAmount){
       this.name = name;
       this.depositAmount = depositAmount;
   }

   public String getName(){
       return this.name;
   }
   public BigDecimal getDepositAmount(){
       return this.depositAmount;
   }
   public String toFileString(){
       DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
       String formattedTime = LocalTime.now().format(timeFormatter);
       return LocalDate.now() + " | " + formattedTime +  " | Deposit | Made By: " + name + " | Deposit Amount: $" + depositAmount;
   }
}
