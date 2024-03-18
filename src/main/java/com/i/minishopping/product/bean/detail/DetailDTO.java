package com.i.minishopping.product.bean.detail;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class DetailDTO {
    private long productId;
    private String size;
    private int pdBeforeCount;
    private int pdSellCount;

    @Override
    public String toString() {
        return productId + "\t" + size + "\t" + pdBeforeCount + "\t" + pdSellCount;
    }
}
