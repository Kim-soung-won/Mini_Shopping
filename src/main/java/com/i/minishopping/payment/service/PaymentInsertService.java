package com.i.minishopping.payment.service;

import com.i.minishopping.payment.bean.PaymentDTO;
import com.i.minishopping.payment.dao.PaymentDAO;
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
public class PaymentInsertService implements PaymentService {
    private final DetailDAO detailDAO;
    private final LogDAO logDAO;
    private final PaymentDAO paymentDAO;
    private final PaymentDTO paymentDTO;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("결제 : ");
        Long paymentId = sc.nextLong();
        System.out.print("등록자 입력 : ");
        Long createWho = sc.nextLong();
        UserDTO userDTO = userDAO.checkCreatedWho(createWho);

        if(userDTO == null) {
            System.out.println();
            System.out.println("찾고자 하는 등록자가 없습니다.");
            return;
        }

        System.out.print("일련번호 입력 : ");
        Long productId = sc.nextLong();
        ProductDTO productDTO = productDAO.checkProductId(productId);

        if(productDTO == null) {
            System.out.println();
            System.out.println("찾고자 하는 일련번호가 없습니다.");
            return;
        }

        System.out.print("총금액 입력 : ");
        int totalPrice = sc.nextInt();
        System.out.print("사이즈 입력 : ");
        String size = sc.next();
        DetailDTO detailDTO = detailDAO.checkSize(size);

        if(detailDTO == null) {
            System.out.println();
            System.out.println("찾고자 하는 사이즈가 없습니다.");
            return;
        }

        System.out.print("수량 입력 : ");
        int count = sc.nextInt();
        LogDTO logDTO = logDAO.checkCount(count);

        if(logDTO == null) {
            System.out.println();
            System.out.println("찾고자 하는 수량이 없습니다.");
            return;
        }

        paymentDTO.setPaymentId(paymentId);
        paymentDTO.setCreatedWho(createWho);
        paymentDTO.setProductId(productId);
        paymentDTO.setTotalPrice(totalPrice);
        paymentDTO.setSize(size);
        paymentDTO.setCount(count);

        paymentDAO.writePayment(paymentDTO);

        System.out.println("데어터 저장됐습니다.");

    }
}
