package com.i.minishopping.user.service;

import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.bean.UserDetailDTO;
import com.i.minishopping.user.dao.UserDAO;
import com.i.minishopping.user.dao.UserDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class UserDetailUpdateService implements UserService {
    @Autowired
    private UserDetailDAO userDetailDAO;

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println();

        List<UserDetailDTO> list = userDetailDAO.getUserDetailList();

        try {
            System.out.print("수정할 일련번호 입력 : ");
            Long inputUserId = scan.nextLong(); // 변수명 변경 및 예외 처리를 위한 try-catch 블록 내 배치

            int sw = 0;
            for (UserDetailDTO userDetailDTO : list) {

                if (userDetailDTO.getUserId().equals(inputUserId)) { // 객체 비교를 위한 .equals() 사용

                    System.out.println(userDetailDTO);
                    System.out.println();

                    System.out.print("수정할 이름 입력 : ");
                    String name = scan.next(); // 변수명 첫 글자는 소문자로
                    System.out.print("수정할 키 입력 : ");
                    byte height = scan.nextByte(); // byte 타입 변수명 첫 글자는 소문자로
                    System.out.print("수정할 몸무게 입력 : ");
                    byte weight = scan.nextByte(); // byte 타입 변수명 첫 글자는 소문자로

                    // 입력 받은 값으로 업데이트
                    userDetailDTO.setName(name);
                    userDetailDTO.setHeight(height);
                    userDetailDTO.setWeight(weight);

                    userDetailDAO.updateUserDetail(userDetailDTO);
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