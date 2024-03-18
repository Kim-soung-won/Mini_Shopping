package com.i.minishopping.user.dao;

import com.i.minishopping.user.bean.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    void insertUser(UserDTO userDTO); // 사용자를 삽입하는 메소드

    List<UserDTO> getUserList(); // 사용자 목록을 조회하는 메소드

    UserDTO getUserById(Long userId);

    void updateUser(UserDTO userDTO);

    void deleteUser(Long userDTO); // 사용자를 삭제하는 메소드

    UserDTO checkCreatedWho(Long createdWho);
    UserDTO selectUserByEmailAndPassword(String email, String password);
}
