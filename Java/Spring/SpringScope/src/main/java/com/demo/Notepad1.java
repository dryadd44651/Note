package com.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//default scope is singleton
//prototype's default is lazy loading
@Component
//@Scope("prototype")
//@Scope(scopeName = "prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class Notepad1 {
    public Notepad1() {
        super();
        System.out.println("notepad1"+this.toString());
    }
    public void foo(){
        System.out.println("hello");
    }
    @PostConstruct
    public void  init(){
        System.out.println("notepad1 init");
    }
    //this won't be called
    @PreDestroy
    public void  destroy(){
        System.out.println("notepad1 destroy");
    }
}
