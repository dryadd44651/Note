package com.antra2;

public class ThreadEx3 extends Thread{
	
	A a;
	B b;
	
	public ThreadEx3(A a, B b) {
		this.a=a;
		this.b=b;
	}
	public void run() {
		a.foo(b);
	}

}
