package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class LoadingTest {
    @Test
    public void test(){

    }
    //only Notepad3 is being created
    //Notepad1 => prototype => lazy
    //Notepad2 => singleton and set to lazy
    //Notepad3 => singleton => eager
    //lazy loading can speed up the initialization of app
}
