package com.i.minishopping.user.service;

import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Lombok을 사용하여 생성자 주입을 간결하게 처리
public class UserRegistrationService {

    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    public void registerUser(UserDTO user) {
        String encryptedPassword = passwordEncoder.encode(user.getUserPassword());
        System.out.println("암호화된 비밀번호: " + encryptedPassword); // 디버깅 목적의 로그
        user.setUserPassword(encryptedPassword);

        userDAO.insertUser(user);
        System.out.println("사용자 등록 성공");
    }

}
