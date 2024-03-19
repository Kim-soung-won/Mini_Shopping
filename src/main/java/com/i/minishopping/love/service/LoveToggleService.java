package com.i.minishopping.love.service;

import com.i.minishopping.love.bean.LoveDTO;
import com.i.minishopping.love.dao.LoveDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoveToggleService implements LoveService {

    private final LoveDAO loveDAO;

    @Override
    public List<LoveDTO> selectLovedProductsByUser(Long userId) {
        throw new UnsupportedOperationException("Not supported in LoveToggleService");
    }

    @Override
    public void toggleLove(Long userId, Long productId) {
        boolean exists = loveDAO.existsByUserIdAndProductId(userId, productId);

        if (exists) {
            loveDAO.deleteByUserIdAndProductId(userId, productId);
        } else {
            LoveDTO love = new LoveDTO();
            love.setUserId(userId);
            love.setProductId(productId);
            love.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            loveDAO.insertLove(love);
        }
    }
}
