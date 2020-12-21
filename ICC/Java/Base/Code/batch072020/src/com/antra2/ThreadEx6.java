package com.antra2;

public class ThreadEx6 extends Thread{

	public void run() {
		System.out.println(Thread.currentThread());
		System.out.println("in thread t6");
	}
}
