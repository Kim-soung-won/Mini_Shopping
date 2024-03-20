package com.i.minishopping.love.service;

import com.i.minishopping.love.dao.LoveDAO;
import com.i.minishopping.love.bean.LoveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime; // LocalDateTime을 사용하기 위해 임포트합니다.

@Service
@RequiredArgsConstructor
public class LoveInsertService implements LoveService {
    private final LoveDAO loveDAO;

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nuser ID: ");
        Long userId = scan.nextLong();
        System.out.println("product ID: ");
        Long productId = scan.nextLong();

        if (loveDAO.existsLove(userId, productId)) {
            loveDAO.deleteLove(userId, productId); // 좋아요 취소 로직 호출
            System.out.println("좋아요가 취소되었습니다.");
        } else {
            LoveDTO loveDTO = new LoveDTO();
            loveDTO.setUserId(userId);
            loveDTO.setProductId(productId);
            loveDTO.setCreatedAt(LocalDateTime.now());
            loveDAO.insertLove(loveDTO);
            System.out.println("좋아요가 등록되었습니다.");
        }
    }


    public void printLovesByUserId(Long userId) {
        List<LoveDTO> loves = loveDAO.selectLovesByUserId(userId);
        System.out.println(userId + "번 사용자가 좋아하는 상품 목록:");
        for (LoveDTO love : loves) {
            System.out.println("상품 ID: " + love.getProductId());
        }
    }
}
