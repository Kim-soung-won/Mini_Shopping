package com.i.minishopping.payment.service;

import com.i.minishopping.payment.bean.PaymentDTO;
import com.i.minishopping.payment.dao.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PaymentUpdateService implements PaymentService {
    private  PaymentDAO paymentDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        List<PaymentDTO> list = paymentDAO.getPaymentList();

        System.out.print("수정할 일련번호 입력 : ");
        Long productId = sc.nextLong();

        int sw = 0;
        for(PaymentDTO paymentDTO : list) {
            if(paymentDTO.getProductId() == productId) {
                System.out.println(paymentDTO);
                System.out.println();

                System.out.print("수정할 결제 : ");
                Long paymentId = sc.nextLong();
                System.out.print("수정할 총금액 : ");
                int totalPrice = sc.nextInt();

                paymentDTO.setPaymentId(paymentId);
                paymentDTO.setTotalPrice(totalPrice);

                paymentDAO.updatePayment(paymentDTO);
                sw = 1;
                System.out.println("수정을 완료했습니다.");
                break;
            }
        }

        if(sw == 0) {
            System.out.println("존재하지 않습니다.");
        }

    }
}
