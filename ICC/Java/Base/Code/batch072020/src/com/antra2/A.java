package com.antra2;

public class A {
	
	public A() {
		System.out.println("in a constructor");
	}

	public synchronized void foo(B b) {
		System.out.println("In foo method of class A");
		b.last();
	}
	
	public synchronized void last() {
		
		System.out.println("in A class last method");
	}
}
