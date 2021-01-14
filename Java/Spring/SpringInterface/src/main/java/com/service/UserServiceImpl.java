package com.service;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("normal")//inject with name (for Qualifier)
//@Component
//when UserService is implemented by multi-class, we can solve this by
//Primary, Qualifier
//@Primary
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("add user");
        userDao.add();
    }
}
