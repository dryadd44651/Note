package com.app;

public class Dao implements DaoInterface{
    @Override
    public void add(){
        System.out.println("add into DB");
    }
}
