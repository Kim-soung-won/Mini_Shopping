package com.i.minishopping.user.dao;

import com.i.minishopping.user.bean.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    void insertUser(UserDTO userDTO); // 사용자를 삽입하는 메소드

    List<UserDTO> getUserList(); // 사용자 목록을 조회하는 메소드

    UserDTO getUserById(String id); // ID를 기반으로 사용자를 조회하는 메소드

    void updateUser(UserDTO user); // 기존 사용자 정보를 업데이트하는 메소드

    void deleteUser(String id); // 사용자를 삭제하는 메소드

    UserDTO checkCreatedWho(Long createdWho);
}
