package com.i.minishopping.user.dao;

import com.i.minishopping.user.bean.UserDetailDTO;

import java.util.List;

public interface UserDetailDAO {
    void insertUserDetail(UserDetailDTO userDetailDTO);
    void updateUserDetail(UserDetailDTO userDetailDTO);
    List<UserDetailDTO> getUserDetailList();

    UserDetailDTO getUserById(Long userID);


    void deleteUserDetail(Long userDetailDTO);
}