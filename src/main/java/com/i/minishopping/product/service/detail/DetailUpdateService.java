package com.i.minishopping.product.service.detail;

import com.i.minishopping.product.bean.detail.DetailDTO;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.detail.DetailDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;


@Service
@RequiredArgsConstructor
public class DetailUpdateService implements DetailService {
    private final DetailDAO detailDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        List<DetailDTO> list = detailDAO.getDetailList();

        System.out.print("수정할 일련번호 입력 : ");
        Long productId = sc.nextLong();

        int sw = 0;
        for(DetailDTO detailDTO : list) {

            if(detailDTO.getProductId() == productId) {

                System.out.println(detailDTO);
                System.out.println();

                System.out.println("수정할 제품명 입력 : ");
                String size = sc.next();
                System.out.println("수정할 가격 입력 : ");
                int pdBeforeCount = sc.nextInt();
                System.out.println("수정할 카테고리 입력 : ");
                int pdSellCount = sc.nextInt();


                detailDTO.setSize(size);
                detailDTO.setPdBeforeCount(pdBeforeCount);
                detailDTO.setPdSellCount(pdSellCount);

                detailDAO.updateDetail(detailDTO);
                sw = 1;
                System.out.println("수정을 완료했습니다.");

                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }
}
