package com.i.minishopping.user.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public interface LoginService {
    boolean login(String userId, String password);
}