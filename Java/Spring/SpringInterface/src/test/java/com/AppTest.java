package com;

import com.config.AppConfig;
import com.dao.UserDao;
import com.service.UserService;
import com.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserController userController;
    @Test
    public void testDaoAdd(){
        userDao.add();

    }
    @Test
    public void testServiceAdd(){
        userService.add();
    }
    @Test
    public void testController(){
        userController.add();
    }
}
