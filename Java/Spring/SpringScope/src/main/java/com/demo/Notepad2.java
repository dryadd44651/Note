package com.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//singleton's default is eager loading
//we can set as lazy loading by @Lazy
@Component
//@Scope("singleton")
//@Scope(scopeName = "singleton")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy
public class Notepad2 {
    public Notepad2() {
        super();
        System.out.println("notepad2"+this.toString());
    }
    @PostConstruct
    public void  init(){
        System.out.println("notepad2 init");
    }
    @PreDestroy
    public void  destroy(){
        System.out.println("notepad2 destroy");
    }
}
