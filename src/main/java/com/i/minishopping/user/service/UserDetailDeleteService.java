package com.i.minishopping.user.service;

import com.i.minishopping.user.dao.UserDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ScopeNotActiveException;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserDetailDeleteService implements UserService{
    @Autowired
    private UserDetailDAO userDetailDAO;

    @Override
    public void execute(){
        Scanner scan = new Scanner(System.in);

        System.out.println("삭제할 ID 입력 : ");
        Long userId = scan.nextLong();

        if(userDetailDAO.getUserById(userId)!=null){
            userDetailDAO.deleteUserDetail(userId);
        }else{
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }
}