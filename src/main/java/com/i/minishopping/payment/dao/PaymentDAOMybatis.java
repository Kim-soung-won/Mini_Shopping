package com.i.minishopping.payment.dao;

import com.i.minishopping.payment.bean.PaymentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PaymentDAOMybatis implements PaymentDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void writePayment(PaymentDTO paymentDTO) {
        sqlSession.insert("paymentSQL.writePayment", paymentDTO);
    }

    @Override
    public List<PaymentDTO> getPaymentList() {
        return sqlSession.selectList("paymentSQL.getPaymentList");
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        sqlSession.update("paymentSQL.updatePayment", paymentDTO);
    }

    @Override
    public void deletePayment(PaymentDTO paymentDTO) {
        sqlSession.delete("paymentSQL.deletePayment", paymentDTO);
    }
}
