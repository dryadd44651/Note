package com.antra1;

public class Parent {
	
	final int parentI=67;

	int i=10;
	public void parentM1() {
		System.out.println("parent class m1 method");
	}
	
	public void parentM1(int i, int j) {
		System.out.println("parent class m1 method with int i and int j");
	}
	
	public void commen() {
		System.out.println("in common method of parent");
	}
}
