package com.i.minishopping.love.service;

import com.i.minishopping.love.bean.LoveDTO;
import com.i.minishopping.love.dto.LoveDTO;
import java.util.List;

public interface LoveService {
    void toggleLove(Long userId, Long productId);
    // 유저별로 좋아요한 상품을 출력해줄 수 있어야함
    List<LoveDTO> getLovesByUserId(Long userId);
    // 좋아요를 눌렀을 때 있으면 delete 없으면 Insert

}
