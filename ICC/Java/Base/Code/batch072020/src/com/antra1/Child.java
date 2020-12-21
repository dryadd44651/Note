package com.antra1;

public class Child extends Parent{

	int childJ=89;
	int i=20;
	public void childM1() {
		System.out.println(super.i);
		System.out.println("in child m1");
	}
	
	public void commen() {
		System.out.println("in common method of child");
	}
	
}
