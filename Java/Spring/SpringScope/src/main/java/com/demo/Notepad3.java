package com.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Notepad3 {
    public Notepad3() {
        super();
        System.out.println("notepad3"+this.toString());
    }
    @PostConstruct
    public void  init(){
        System.out.println("notepad3 init");
    }
    @PreDestroy
    public void  destroy(){
        System.out.println("notepad3 destroy");
    }
}
