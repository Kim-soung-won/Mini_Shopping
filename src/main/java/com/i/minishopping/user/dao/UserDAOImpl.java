package com.i.minishopping.user.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.i.minishopping.user.bean.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {


    private final SqlSession sqlSession;


    @Override
    public void insertUser(UserDTO userDTO)
    {
        sqlSession.insert("userSQL.writeUser", userDTO);
    }

    @Override
    public List<UserDTO> getUserList() {
        return sqlSession.selectList("userSQL.getUserList"); // 사용자 목록을 반환 (새로운 리스트로 반환하여 외부에서의 변경 방지)
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return sqlSession.selectOne("userSQL.getUserById", userId);
    }
    @Override
    public void updateUser(UserDTO userDTO){

        sqlSession.update("userSQL.updateUser",userDTO);
    }

    @Override
    public void deleteUser(Long userId) {
        sqlSession.delete("userSQL.deleteUser",userId);

    }


    @Override
    public UserDTO checkCreatedWho(Long createdWho) {
        return sqlSession.selectOne("userSQL.checkCreatedWho", createdWho);
    }
    @Override
    public UserDTO selectUserByEmailAndPassword(String userEmail, String userPassword) {
        // MyBatis의 parameterType이 Map일 때는, 파라미터를 Map 객체에 담아서 전달합니다.
        Map<String, Object> params = new HashMap<>();
        params.put("userEmail", userEmail);
        params.put("userPassword", userPassword);
        return sqlSession.selectOne("userSQL.getUserByEmailAndPassword", params);
    }

    @Override
    public UserDTO getUserByEmail(String userEmail) {
        // userEmail 파라미터를 사용하여 데이터베이스에서 사용자를 조회합니다.
        return sqlSession.selectOne("userSQL.getUserByEmail", userEmail);
    }

   
}
