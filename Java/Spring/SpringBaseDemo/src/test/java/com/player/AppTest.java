package com.player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class AppTest {
    //normal junit test
    @Test
    public void testPlay1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Second second = context.getBean(Second.class);
        second.play();
    }
    //need RunWith and ContextConfiguration
    @Autowired
    private Second second;
    @Test
    public void testPlay2() {

        second.play();
    }
}
