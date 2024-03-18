package com.i.minishopping.user.service;

import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements LoginService {

    private final UserDAO userDAO;

    @Autowired
    public UserLoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean login(String userId, String password) { // 메소드 이름 및 파라미터 수정
        UserDTO user = userDAO.selectUserByEmailAndPassword(userId, password); // 메소드 명명 규칙에 따라 수정

        if(user != null) {
            System.out.println("맞았습니다."); // 로그인 성공 시
            return true;
        } else {
            System.out.println("틀렸습니다."); // 로그인 실패 시
            return false;
        }
    }
}