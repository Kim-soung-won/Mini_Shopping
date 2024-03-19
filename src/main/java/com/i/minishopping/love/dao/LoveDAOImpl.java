package com.i.minishopping.love.dao;

import com.i.minishopping.love.bean.LoveDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class LoveDAOImpl implements LoveDAO {
    private final SqlSession sqlSession;

    @Override
    public void insertLove(LoveDTO loveDTO) {
        sqlSession.insert("loveSQL.insertLove", loveDTO);
    }

    @Override
    public void deleteLove(Long productId, Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("productId", productId);
        params.put("userId", userId);
        sqlSession.delete("loveSQL.deleteLove", params);
    }

    @Override
    public List<LoveDTO> selectLovesByUserId(Long userId) {
        return sqlSession.selectList("loveSQL.selectLovesByUserId", userId);
    }


    @Override
    public boolean existsLove(Long productId, Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("productId", productId);
        params.put("userId", userId);
        Integer count = sqlSession.selectOne("loveSQL.existsLove", params);
        return count != null && count > 0; // Integer 결과를 boolean으로 변환
    }
}
