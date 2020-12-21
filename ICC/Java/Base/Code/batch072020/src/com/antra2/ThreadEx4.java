package com.antra2;

public class ThreadEx4 extends Thread{
	
	A a;
	B b;
	public ThreadEx4(A a, B b) {
		this.a=a;
		this.b=b;
	}
	
	public void run() {
		b.bar(a);
	}

}
