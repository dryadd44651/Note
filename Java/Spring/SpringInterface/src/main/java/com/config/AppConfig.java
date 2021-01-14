package com.config;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//set scan root to com
@ComponentScan("com")
//@ComponentScan(basePackages = {"com.dao","com.service"})//set multi package
//@ComponentScan(basePackageClasses = {UserService.class, UserDao.class})//set multi class
public class AppConfig {
    public static void main(String[] args) {

    }
}
