package com.i.minishopping.product.service.detail;

import com.i.minishopping.product.bean.detail.DetailDTO;
import com.i.minishopping.product.dao.detail.DetailDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;


@Service
@RequiredArgsConstructor
public class DetailDeleteService implements DetailService {
    private final DetailDAO detailDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 일련번호 입력 : ");
        Long productId = sc.nextLong();

        List<DetailDTO> list = detailDAO.getDetailList();

        int sw = 0;
        for(DetailDTO detailDTO : list) {

            if(detailDTO.getProductId() == productId) {

                sw = 1;
                detailDAO.deleteDetail(detailDTO);
                list.remove(detailDTO);

                System.out.println("삭제를 완료했습니다.");
                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }
}
