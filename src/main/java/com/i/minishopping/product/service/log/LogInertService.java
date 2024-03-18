package com.i.minishopping.product.service.log;

import com.i.minishopping.product.bean.detail.DetailDTO;
import com.i.minishopping.product.bean.log.LogDTO;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.detail.DetailDAO;
import com.i.minishopping.product.dao.log.LogDAO;
import com.i.minishopping.product.dao.product.ProductDAO;
import com.i.minishopping.user.bean.UserDTO;
import com.i.minishopping.user.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class LogInertService implements LogService {
    private final DetailDAO detailDAO;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;
    private final LogDTO logDTO;
    private final LogDAO logDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.print("일련번호 입력 : ");
        Long productId = sc.nextLong();
        ProductDTO productDTO = productDAO.checkProductId(productId);
        if(productDTO == null) {
            System.out.println("찾고자 하는 일련번호가 없습니다.");
            return;
        }

        System.out.print("사이즈 입력 : ");
        String size = sc.next();
        DetailDTO detailDTO = detailDAO.checkSize(size);
        if(detailDTO == null) {
            System.out.println("찾고자 하는 사이즈가 없습니다.");
            return;
        }

        System.out.print("수량 : ");
        int count = sc.nextInt();
        System.out.print("등록자 : 입력");
        Long createdWho = sc.nextLong();
        UserDTO userDTO = userDAO.checkCreatedWho(createdWho);

        System.out.println();
        if(userDTO == null) {
            System.out.println("찾고자 하는 등록자가 없습니다.");
            return;
        }

        logDTO.setProductId(productId);
        logDTO.setSize(size);
        logDTO.setCount(count);
        logDTO.setCreatedWho(createdWho);

        logDAO.writeLog(logDTO);

        System.out.println("데이터가 저장됐습니다.");
    }
}
