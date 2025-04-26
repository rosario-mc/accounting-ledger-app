package capstone1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
       return LocalDate.now() + " | " + LocalTime.now() +  " | Deposit | Made by: " + name + " | Deposit Amount: $" + depositAmount;
   }



}
