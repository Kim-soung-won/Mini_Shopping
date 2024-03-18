package com.i.minishopping.product.service.log;

import com.i.minishopping.product.bean.detail.DetailDTO;
import com.i.minishopping.product.bean.log.LogDTO;
import com.i.minishopping.product.dao.log.LogDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class LogDeleteService implements LogService {
    private final LogDAO logDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 일련번호 입력 : ");
        Long productId = sc.nextLong();

        List<LogDTO> list = logDAO.getLogList();

        int sw = 0;
        for(LogDTO logDTO : list) {

            if(logDTO.getProductId() == productId) {

                sw = 1;
                logDAO.deleteLog(logDTO);
                list.remove(logDTO);

                System.out.println("삭제를 완료했습니다.");
                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }
}
