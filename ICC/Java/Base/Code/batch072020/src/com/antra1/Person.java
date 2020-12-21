package com.antra1;

public class Person {
	
	int pId=98;
	static int phones=8974;
	
	public void m1() {
		int i;
		//System.out.println(i);
		System.out.println("in m1 of Person");
		//System.out.println(phone);
		System.out.println(pId);
	}
	
	public static void m2() {
		int i;
		//System.out.println(i);
		//System.out.println(pid);//not possible
		System.out.println("in static method");
	}
 
}
