package com.i.minishopping.payment.service;

import com.i.minishopping.payment.bean.PaymentDTO;
import com.i.minishopping.payment.dao.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PaymentInsertService implements PaymentService {
    private final PaymentDAO paymentDAO;
    private final PaymentDTO paymentDTO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

    }
}
