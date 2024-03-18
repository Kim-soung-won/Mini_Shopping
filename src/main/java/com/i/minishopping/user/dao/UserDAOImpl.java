package com.i.minishopping.user.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.i.minishopping.user.bean.UserDTO;

import java.util.ArrayList;
import java.util.List;

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
    public UserDTO getUserById(String id) {
        return null; // 주어진 ID와 일치하는 사용자를 찾지 못하면 null 반환
    }

    @Override
    public void updateUser(UserDTO user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public UserDTO checkCreatedWho(Long createdWho) {
        return sqlSession.selectOne("userSQL.checkCreatedWho", createdWho);
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
