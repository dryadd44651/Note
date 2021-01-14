package com.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com")
public class Config {
    //Java Config
    @Bean
    @Scope("singleton")
    //@Lazy
    //@Scope(scopeName = "singleton")
    //@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Notepad3 notepad3(){
        return new Notepad3();
    }

}
