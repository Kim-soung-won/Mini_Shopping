package com.i.minishopping.love.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Setter
@Getter
@Component
public class LoveDTO {
    private Long productId;
    private Long userId;
    private LocalDateTime createdAt;
}
