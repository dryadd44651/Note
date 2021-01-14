package com.app;

public class Service {
    private DaoInterface dao;
    public void add(){
        dao.add();
    }

    public Service(DaoInterface dao) {
        this.dao = dao;
    }


}
