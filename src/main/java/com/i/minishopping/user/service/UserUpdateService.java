package com.i.minishopping.user.service;

import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class UserUpdateService implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println();

        List<UserDTO> list = userDAO.getUserList();

        try {
            System.out.print("수정할 일련번호 입력 : ");
            Long inputUserId = scan.nextLong(); // 변수명 변경 및 예외 처리를 위한 try-catch 블록 내 배치

            int sw = 0;
            for (UserDTO userDTO : list) {

                if (userDTO.getUserId() == inputUserId) { // 객체 비교를 위해 == 대신 .equals() 사용

                    System.out.println(userDTO);
                    System.out.println();

                    System.out.print("수정할 Email 입력 : ");
                    String userEmail = scan.next();
                    System.out.print("수정할 비밀번호 입력 : ");
                    String userPassword = scan.next();
                    System.out.print("수정할 폰번호 입력 : ");
                    String userPnum = scan.next(); // 변수명 Pnum에서 userPnum으로 변경

                    // 올바른 값으로 업데이트
                    userDTO.setUserId(inputUserId);
                    userDTO.setUserEmail(userEmail);
                    userDTO.setUserPassword(userPassword);
                    userDTO.setUserPnum(userPnum);

                    userDAO.updateUser(userDTO);
                    sw = 1;
                    System.out.println("수정을 완료했습니다.");

                    break;
                } // if
            } // enhanced for

            if (sw == 0) {
                System.out.println("아이디가 존재하지 않습니다.");
            } // if
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            scan.nextLine(); // 잘못된 입력을 비워주는 역할
        }
    } // execute
} // end class