package com.i.minishopping.user.service;


import com.i.minishopping.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserDeleteService implements UserService {
    @Autowired
    private UserDAO userDAO;



    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);

        System.out.print("삭제할 Id 입력 : ");
        Long userId = scan.nextLong();




        if (userDAO.getUserById(userId) != null) {
            userDAO.deleteUser(userId);
            System.out.println("삭제를 완료했습니다.");
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }
}