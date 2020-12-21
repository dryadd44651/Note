package com.antra1;

public class ExceptionEx2 {

	public static void main(String[] args) {
		System.out.println("in main method before dostuff");
		doStuff();
		System.out.println("in main method after dostuff");
	}
	
	public static void doStuff() {
		System.out.println("in dostuff before domoreStuff");
		doMoreStuff();
		System.out.println("in dostuff after domoreStuff");

	}
	
	public static void doMoreStuff() {
		System.out.println("in do more stuff");
		try {
		System.out.println(1/0);
		}catch(Exception e) {
			
		}
	}
}
