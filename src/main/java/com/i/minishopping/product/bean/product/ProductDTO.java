package com.i.minishopping.product.bean.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Setter
@Getter
@Component
public class ProductDTO {
    private Long productId;
    private String pdName;
    private int pdPrice;
    private Long brandId;
    private String pdCategory;
    private Long createdWho;
    private LocalDateTime createdAt;
    private int countLove;

    @Override
    public String toString() {
        return productId + "\t"
                + pdName + "\t"
                + pdPrice + "\t"
                + brandId + "\t"
                + pdCategory + "\t"
                + createdWho + "\t"
                + createdAt + "\t"
                + countLove;
    }
}
