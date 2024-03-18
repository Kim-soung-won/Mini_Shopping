package com.i.minishopping.user.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class UserDTO {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private UserRole userRole;
    private String userPnum;

    @Override
    public String toString() {
        return userEmail + "\t" + userId + "\t" + userPassword +"\t" + userPnum;
    }
}
