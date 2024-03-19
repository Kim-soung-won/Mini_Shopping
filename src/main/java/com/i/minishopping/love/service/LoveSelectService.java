package com.i.minishopping.love.service;

import com.i.minishopping.love.bean.LoveDTO;
import com.i.minishopping.love.dao.LoveDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LoveSelectService implements LoveService {
    @Autowired
    private LoveDAO loveDAO;

    private Long userId; // 예시로 사용할 사용자 ID

    // 기본 생성자 사용
    public LoveSelectService() {
    }

    @Override
    public void execute() {
        // 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("사용자 ID를 입력하시겠습니까? (예/아니오): ");
        String answer = scanner.nextLine();

        if ("예".equals(answer)) {
            System.out.print("사용자 ID: ");
            // 사용자 ID 입력 받기
            this.userId = Long.parseLong(scanner.nextLine()); // 입력받은 사용자 ID 설정
            List<LoveDTO> loves = loveDAO.selectLovesByUserId(userId);
            if (loves != null && !loves.isEmpty()) {
                for (LoveDTO love : loves) {
                    System.out.println("상품 ID: " + love.getProductId() + ", 좋아요 누른 시각: " + love.getCreatedAt());
                }
            } else {
                System.out.println("사용자 ID " + userId + " 가 좋아요를 누른 상품이 없습니다.");
            }
        } else {
            System.out.println("사용자 ID 입력을 건너뜁니다.");
        }
    }
}
