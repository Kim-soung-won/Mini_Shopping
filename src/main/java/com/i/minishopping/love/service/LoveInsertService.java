package com.i.minishopping.love.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.i.minishopping.love.dao.LoveDAO;
import com.i.minishopping.love.bean.LoveDTO;

@Service
public class LoveInsertService {
    @Autowired
    private LoveDAO loveDAO;

    public void insertLove(Long userId, Long productId) {
        LoveDTO loveDTO = new LoveDTO();
        loveDTO.setUserId(userId);
        loveDTO.setProductId(productId);
        loveDTO.setCreatedAt(new java.sql.Timestamp(new java.util.Date().getTime()));

        loveDAO.insertLove(loveDTO);
    }
}
