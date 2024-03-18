package com.i.minishopping.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.dao.UserDAO;

import java.util.List;

@Service
public class UserSelectService implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println("데이터 조회 처리");

        List<UserDTO> list = userDAO.getUserList();

        System.out.println("이메일\tID\t비밀번호\t전화번호");
        for(UserDTO userDTO : list) {
            if(userDTO != null) { // null 체크 추가
                System.out.println(userDTO); // toString()은 생략 가능합니다.
            } else {
                System.out.println("빈 데이터");
            }
        }
    }
}
