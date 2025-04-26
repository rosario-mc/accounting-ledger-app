package capstone1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        return LocalDate.now() + " | " + LocalTime.now() +  " | Payment | Paid by: " + name1 + " | Payable to: " + payableToCo+ " | Payment Amount: $" + paymentAmount;
    }
}


