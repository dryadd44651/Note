package com.player;
import org.springframework.stereotype.Component;

@Component
public class First {
    public First() {
        super();
        System.out.println("First");
    }
    public void play(){
        System.out.println("playing");
    }
}
