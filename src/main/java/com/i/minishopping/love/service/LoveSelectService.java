package com.i.minishopping.love.service;

import com.i.minishopping.love.bean.LoveDTO;
import com.i.minishopping.love.dao.LoveDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoveSelectService implements LoveService {
    private final LoveDAO loveDAO;

    @Override
    public List<LoveDTO> selectLovedProductsByUser(Long userId) {
        return loveDAO.findLovedProductsByUserId(userId);
    }

    // toggleLove 메서드는 LoveSelectService에서 구현되지 않습니다.
    @Override
    public void toggleLove(Long userId, Long productId) {
        throw new UnsupportedOperationException("Not supported in LoveSelectService");
    }
}
