package com.antra2;

public class DeadLockEx {
	
	public static void main(String[] args) {
		
		A a=new A();
		B b=new B();
		ThreadEx3 t1=new ThreadEx3(a,b);
		ThreadEx4 t2=new ThreadEx4(a,b);
		t1.start();
		t2.start();
		
		
	}

}
