package com.i.minishopping.love.dao;


import com.i.minishopping.love.bean.LoveDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoveDAO {
    void insertLove(LoveDTO love);
    void deleteLove(Long productId, Long userId);
    List<LoveDTO> selectLovesByUserId(Long userId);
    boolean existsLove(Long productId, Long userId);
}
