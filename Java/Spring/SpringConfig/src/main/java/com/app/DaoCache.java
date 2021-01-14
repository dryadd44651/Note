package com.app;

public class DaoCache implements DaoInterface{
    @Override
    public void add() {
        System.out.println("add into cache");
    }
}
