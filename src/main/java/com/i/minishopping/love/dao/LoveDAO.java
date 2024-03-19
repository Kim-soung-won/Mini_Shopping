package com.i.minishopping.love.dao;

import com.i.minishopping.love.bean.LoveDTO;

import java.util.List;
import java.util.Map;

public interface LoveDAO {
    void insertLove(LoveDTO love);
    void deleteLove(Long userId, Long productId);
    List<LoveDTO> selectLovesByUserId(Long userId);
}