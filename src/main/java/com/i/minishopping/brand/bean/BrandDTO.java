package com.i.minishopping.brand.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class BrandDTO {
    private Long brandId;
    private String brandName;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return brandId + "\t" + brandName + "\t" + createdAt;
    }
}