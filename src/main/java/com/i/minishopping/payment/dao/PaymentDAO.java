package com.i.minishopping.payment.dao;

import com.i.minishopping.payment.bean.PaymentDTO;

import java.util.List;

public interface PaymentDAO {
    void writePayment(PaymentDTO paymentDTO);

    List<PaymentDTO> getPaymentList();

    void updatePayment(PaymentDTO paymentDTO);

    void deletePayment(PaymentDTO paymentDTO);
}
