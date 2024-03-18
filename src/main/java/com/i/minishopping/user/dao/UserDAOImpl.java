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
    public void insertUser(UserDTO userDTO) {
        sqlSession.insert("userSQL.write", userDTO);
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

    /*@Override
    public void updateUser(UserDTO com.i.minishopping.user) {
        Optional<UserDTO> existingUser = userList.stream()
                .filter(u -> u.getId().equals(com.i.minishopping.user.getId()))
                .findFirst(); // 업데이트하고자 하는 사용자의 ID와 일치하는 기존 사용자를 찾음

        existingUser.ifPresent(u -> {
            userList.set(userList.indexOf(u), com.i.minishopping.user); // 기존 사용자 정보를 새 정보로 업데이트
        });
    }

    @Override
    public void deleteUser(String id) {
        userList.removeIf(com.i.minishopping.user -> com.i.minishopping.user.getId().equals(id)); // 주어진 ID와 일치하는 사용자를 리스트에서 제거
    }*/
}
