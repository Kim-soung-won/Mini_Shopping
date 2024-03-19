package com.i.minishopping.payment.service;

import com.i.minishopping.payment.bean.PaymentDTO;
import com.i.minishopping.payment.dao.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PaymentDeleteService implements PaymentService {
    private final PaymentDAO paymentDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 일련번호 입력 : ");
        Long productId = sc.nextLong();

        List<PaymentDTO> list = paymentDAO.getPaymentList();

        int sw = 0;
        for(PaymentDTO paymentDTO : list) {
            if(paymentDTO.getProductId() == productId) {
                sw = 1;
                paymentDAO.deletePayment(paymentDTO);
                list.remove(paymentDTO);

                System.out.println("삭제 했습니다.");
                break;
            }
        }

        if(sw == 0) {
            System.out.println("존재하지 않습니다.");
        }
    }
}
