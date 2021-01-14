package com.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AppTest {
    @Autowired
    private Notepad1 notepad1a;
    @Autowired
    private Notepad1 notepad1b;
    @Autowired
    private Notepad2 notepad2a;
    @Autowired
    private Notepad2 notepad2b;
    @Autowired
    private Notepad3 notepad3a;
    @Autowired
    private Notepad3 notepad3b;
    //prototype
    @Test
    public void Notepad1Test(){
        System.out.println(notepad1a==notepad1b);
    }//false

    //singleton
    @Test
    public void Notepad2Test(){
        System.out.println(notepad2a==notepad2b);
    }//true
    //singleton
    @Test
    public void Notepad3Test(){
        System.out.println(notepad3a==notepad3b);
    }//true
    @Test
    public void test(){

    }
}
