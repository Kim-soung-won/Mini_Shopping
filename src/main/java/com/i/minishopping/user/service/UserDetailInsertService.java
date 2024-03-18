package com.i.minishopping.user.service;

import com.i.minishopping.user.bean.UserDetailDTO;
import com.i.minishopping.user.bean.Sex;
import com.i.minishopping.user.dao.UserDetailDAO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service

@Setter
@RequiredArgsConstructor
public class UserDetailInsertService implements UserService {

    private final UserDetailDAO userDetailDAO;
    private final UserDetailDTO userDetailDTO;


    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        UserDetailDTO userDetailDTO = new UserDetailDTO();

        System.out.println("사용자 상세 정보 입력");
        System.out.print("사용자 ID: ");
        Long id = scan.nextLong();
        userDetailDTO.setUserId(id);
        scan.nextLine(); // nextLong() 후에 남은 newline 처리
        System.out.print("이름: ");
        userDetailDTO.setName(scan.nextLine());
        System.out.print("키(cm): ");
        userDetailDTO.setHeight(scan.nextByte());
        System.out.print("몸무게(kg): ");
        userDetailDTO.setWeight(scan.nextByte());
        scan.nextLine(); // nextByte() 후에 남은 newline 처리
        System.out.print("성별(M/F): ");
        String sexInput = scan.nextLine().toUpperCase();
        if(sexInput.startsWith("M")) {
            userDetailDTO.setSex(Sex.male);
        } else if(sexInput.startsWith("F")) {
            userDetailDTO.setSex(Sex.female);
        }

        userDetailDAO.insertUserDetail(userDetailDTO);

        System.out.println("사용자 정보가 성공적으로 등록되었습니다.");
    }
}