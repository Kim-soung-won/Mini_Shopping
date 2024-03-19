package com.i.minishopping.payment.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Setter
@Getter
public class PaymentDTO {
    private Long paymentId;
    private Long createdWho;
    private Long productId;
    private int totalPrice;
    private String size;
    private int count;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return paymentId + "\t"
             + createdWho + "\t"
             + productId + "\t"
             + totalPrice + "\t"
             + size + "\t"
             + count + "\t"
             + createdAt;
    }
}
