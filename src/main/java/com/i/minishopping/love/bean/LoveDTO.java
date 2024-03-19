package com.i.minishopping.love.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class LoveDTO {
    private Long productId;
    private Long userId;
    private LocalDateTime createdAt;
}
