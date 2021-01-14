package com.player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//inject the variable(first) with three method
// declaration, setter, constructor
//setter can be replaced by any method
//ex:
// @Autowired
// void method(A a,B b){this.a = a; this.b = b}

@Component
public class Second {

    //if you want to skip first injection
    //use @Autowired(required=false)
    //inject in instance variable (declaration) => slower but easy
    @Autowired
    First first;
    public Second() {
        super();
        System.out.println("second");
    }

//    alt+insert
//    @Autowired
//    public void setFirst(First first) {
//        this.first = first;
//    }

//    ctrl+o
//    inject by constructor => faster
//    @Autowired
//    public Second(First first) {
//        super();
//        this.first = first;
//        System.out.println("second with first");
//    }
    public void play(){
        first.play();
    }

}
