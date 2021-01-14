package com.config;

import com.app.Dao;
import com.app.DaoCache;
import com.app.DaoInterface;
import com.app.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//inject dao without @Component
//use this method(@Bean) when using third part library
@Configuration
public class Config {
    //How to solve ambiguity: @Primary, @Qualifier
    @Bean
    //@Primary
    //@Qualifier("normal")
    //@Bean("normal") = @Qualifier("normal")
    //or default name "dao"
    public DaoInterface dao(){
        System.out.println("create Dao");
        return new Dao();
    }
    @Bean
    //@Qualifier("cache")
    public DaoInterface daoCache(){
        System.out.println("create Dao");
        return new DaoCache();
    }
//    method 1
//    @Bean
//    public Service service(){
//        System.out.println("create service");
//        //Bean creation is singleton, dao only create once.
//        Dao dao = dao();
//        return new Service(dao);
//    }
    //method 2
    //setter also can be used
    @Bean
    public Service service(@Qualifier("dao") DaoInterface daoInterface){
        System.out.println("create service");
        return new Service(daoInterface);
    }

}
