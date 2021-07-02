package com.foxconn.license.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.foxconn.license.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User acc = new User("spring","boot",1);
        try{
            userRepository.save(acc);
            System.out.println("\n\nFinished\n\n");
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
