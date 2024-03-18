package com.i.minishopping.user.service;

import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.bean.UserDetailDTO;
import com.i.minishopping.user.dao.UserDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailSelectService implements UserService{

    @Autowired
    private UserDetailDAO userDetailDAO;
    @Override
    public void execute() {
        System.out.println("데이터 조회 처리");

        List<UserDetailDTO> list = userDetailDAO.getUserDetailList();

        System.out.println("ID\t\t이름\t\t키\t\t몸무게\t\t성별");
        System.out.println(list.size());
        for(UserDetailDTO userDetailDTO : list) {
            if(userDetailDTO != null) { // null 체크 추가
                System.out.println(userDetailDTO); // toString()은 생략 가능합니다.
            } else {
                System.out.println("빈 데이터");
            }
        }
    }
}