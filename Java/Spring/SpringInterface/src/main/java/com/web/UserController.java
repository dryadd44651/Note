package com.web;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class UserController {
    @Autowired
    //@Qualifier("UserServiceImpl")
    private UserService userService;

    public void add(){
        System.out.println("In controller");
        userService.add();
    }
}
