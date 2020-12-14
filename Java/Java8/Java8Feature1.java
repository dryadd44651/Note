import java.util.concurrent.*; 
import java.util.*;
//FunctionalInterface, default method, static method, 
//lambda expressions, anonymous inner class object
@FunctionalInterface 
interface Intre{
    public void m1();
    //default must have body
    public default void m2(){
        System.out.println("m2");
    }
    //must be called by qualifier 'Intre'
    public static void m3(){
        System.out.println("m3");
    }
    //illegal
    //public static default void m4(){}
    
}
class A{
    A(){
        System.out.println("A constructor");
    }
    public void printa(){
        System.out.println("A");
    }
    public static void printa1(){
        System.out.println("A1");
    }
}

public class Test { 
    public static void fun(){
        System.out.println("fun");
    }    
	public static void main(String[] args) throws InterruptedException 
	{ 
        Intre i1 = new Intre(){
            //anonymous inner class object
            //can have other delaresion (variable,method)
            int x=10;
            public void m1(){System.out.println("I1");};
        };
        
        i1.m1();
        //lambda expression can't have delaresion
        Intre i2 = ()->{System.out.println("I2");};
        i2.m1();
        i2.m2();
        //illegal
        //i2.m3();
        Intre.m3();
        //even different function name, still can assign
        A a = new A();
        Intre i3 = a::printa;
        i3.m1();
        Intre i4 = A::printa1;//static fun
        i4.m1();
        Intre i5 = A::new;//assign constructor
        i5.m1();
    } 
}
