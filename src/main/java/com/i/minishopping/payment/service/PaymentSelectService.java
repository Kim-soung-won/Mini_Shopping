package com.i.minishopping.payment.service;

import com.i.minishopping.payment.bean.PaymentDTO;
import com.i.minishopping.payment.dao.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentSelectService implements PaymentService {
    private final PaymentDAO paymentDAO;

    @Override
    public void execute() {
        System.out.println();

        List<PaymentDTO> list = paymentDAO.getPaymentList();
        System.out.println("결제\t등록자\t일련번호\t총금액\t사이즈\t수량\t등록시간");
        for(PaymentDTO paymentDTO : list) {
            System.out.println(paymentDTO.getPaymentId() + "\t\t"
                    + paymentDTO.getCreatedWho() + "\t\t"
                    + paymentDTO.getProductId() + "\t"
                    + paymentDTO.getTotalPrice() + "\t\t"
                    + paymentDTO.getSize() + "\t\t"
                    + paymentDTO.getCount() + "\t"
                    + paymentDTO.getCreatedAt());
        }

    }
}
