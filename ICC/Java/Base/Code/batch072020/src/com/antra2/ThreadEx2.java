package com.antra2;

public class ThreadEx2 extends Thread{

	Calculate cl;
	public ThreadEx2(Calculate cl) {
		this.cl=cl;
	}
	
	@Override
	public void run() {
		cl.printMul(5);
	}

}
