package com.antra1;

public class StaticControlFlowEx {

	static int i=10;
	
	public static void main(String[] args) {
		System.out.println("in main method");
		m1();
	}
	static {
		System.out.println("in static block1");
	}
	public static void m1() {
		System.out.println("in static m1 method");
	} 
	
	static {
		System.out.println("in static block2");
	}
}
