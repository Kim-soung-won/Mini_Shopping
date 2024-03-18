package com.i.minishopping.user.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class UserDetailDTO {
    private Long userId;
    private String name;
    private Byte height;  // tinyint는 Java의 Byte 타입과 호환됩니다.
    private Byte weight;  // tinyint는 Java의 Byte 타입과 호환됩니다.
    private Sex sex;

    @Override
    public String toString() {
        { return userId + "\t\t" +
                name + "\t\t" +
                height + "\t\t" +
                weight + "\t\t" +
                sex;}

    }
}