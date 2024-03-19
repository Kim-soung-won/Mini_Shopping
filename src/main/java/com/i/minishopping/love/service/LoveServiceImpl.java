package com.i.minishopping.love.service;

import com.i.minishopping.love.dao.LoveDAO;
import com.i.minishopping.love.dto.LoveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveDAO loveDAO;

    @Override
    public void toggleLove(Long userId, Long productId) {
        LoveDTO existingLove = loveDAO.findLoveByUserIdAndProductId(userId, productId);

        if (existingLove != null) {
            loveDAO.deleteLove(userId, productId);
        } else {
            LoveDTO newLove = new LoveDTO();
            newLove.setProductId(productId);
            newLove.setCreatedWho(userId);
            loveDAO.insertLove(newLove);
        }
    }

    @Override
    public List<LoveDTO> getLovesByUserId(Long userId) {
        return loveDAO.selectLovesByUserId(userId);
    }
}
