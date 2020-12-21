package com.antra1;

public abstract class Book {

	int bookId;
	String bookName;
	
	public void m1() {
		System.out.println("in instance m1 method of Book class");
	}
	
	public static void m2() {
		
		System.out.println("in static m2 method of Book class");
	}
	
	public abstract void m3(); 
}
