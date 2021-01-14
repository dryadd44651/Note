package com.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("add to DataBase");
    }
}
