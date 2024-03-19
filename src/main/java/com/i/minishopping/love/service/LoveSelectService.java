package com.i.minishopping.love.service;

import com.i.minishopping.love.dao.LoveDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class LoveSelectService implements LoveService{
    @Autowired
    private LoveDAO loveDAO;


    @Override
    public void execute() {

    }
}
