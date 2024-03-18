package com.i.minishopping.product.service.log;

import com.i.minishopping.product.bean.log.LogDTO;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.log.LogDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class LogUpdateService implements LogService {
    private final LogDAO logDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        List<LogDTO> list = logDAO.getLogList();

        System.out.print("수정할 일련번호 입력 : ");
        Long productId = sc.nextLong();

        int sw = 0;
        for(LogDTO logDTO : list) {

            if(logDTO.getProductId() == productId) {

                System.out.println(logDTO);
                System.out.println();

                System.out.println("수정할 수량 입력 : ");
                int count = sc.nextInt();
                System.out.println("수정할 카테고리 입력 : ");
                String pd_category = sc.next();


                logDTO.setCount(count);

                logDAO.updateLog(logDTO);
                sw = 1;
                System.out.println("수정을 완료했습니다.");

                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        } // if
    }
}
