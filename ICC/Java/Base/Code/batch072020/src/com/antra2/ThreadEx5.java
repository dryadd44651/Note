package com.antra2;

public class ThreadEx5 extends Thread{

	public void run() {
		System.out.println(Thread.currentThread());
		System.out.println("in thread t5");
	}
}
