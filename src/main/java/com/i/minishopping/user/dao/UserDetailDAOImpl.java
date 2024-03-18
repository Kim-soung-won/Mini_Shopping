package com.i.minishopping.user.dao;

import com.i.minishopping.user.bean.UserDetailDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDetailDAOImpl implements UserDetailDAO{

    private final SqlSession sqlSession;

    @Override
    public void insertUserDetail(UserDetailDTO userDetailDTO) {
        sqlSession.insert("userDetailSQL.writeUserDetail",userDetailDTO);
    }


    @Override
    public List<UserDetailDTO> getUserDetailList() {
        return sqlSession.selectList("userDetailSQL.getUserDetailList");
    }

    @Override
    public UserDetailDTO getUserById(Long userId) {
        return sqlSession.selectOne("userDetailSQL.getUserById",userId);
    }

    @Override
    public void deleteUserDetail(Long userId) {
        sqlSession.delete("userDetailSQL.deleteUserDetail",userId);
    }

    @Override
    public void updateUserDetail(UserDetailDTO userDetailDTO) {
        sqlSession.update("userDetailSQL.updateUserDetail",userDetailDTO);
    }




}