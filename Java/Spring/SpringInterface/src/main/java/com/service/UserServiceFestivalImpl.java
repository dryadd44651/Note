package com.service;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class UserServiceFestivalImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("add festival");
        userDao.add();
    }
}
