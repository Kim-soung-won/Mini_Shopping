package com.i.minishopping.product.bean.log;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Setter
@Getter
@Component
public class LogDTO {
    private Long productId;
    private String size;
    private int count;
	private Long createdWho;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return productId + "\t"
             + size + "\t"
             + count + "\t"
             + createdWho + "\t"
             + createdAt;
    }
}
