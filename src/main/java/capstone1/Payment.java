package capstone1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Payment {
    private String name1;
    private BigDecimal paymentAmount;
    private String payableToCo;

    public Payment(String name1, BigDecimal paymentAmount, String payableToCo){
        this.name1= name1;
        this.paymentAmount = paymentAmount;
        this.payableToCo = payableToCo;
    }

    public String getName1(){
        return this.name1;
    }

    public BigDecimal getPaymentAmount(){
        return this.paymentAmount;
    }

    public String getPayableToCo(){
        return this.payableToCo;
    }

    public String toFileString(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = LocalTime.now().format(timeFormatter);
        return LocalDate.now() + " | " + formattedTime +  " | Payment | Paid By: " + name1 + " | Payable To: " + payableToCo+ " | Payment Amount: $" + paymentAmount;
    }
}


