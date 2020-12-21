package com.antra2;

public class ThreadEx1 extends Thread{
	
	Calculate cl;
	public ThreadEx1(Calculate cl) {
		this.cl=cl;
	}
	
	public void run() {
		
		cl.printMul(2);
	}
}
