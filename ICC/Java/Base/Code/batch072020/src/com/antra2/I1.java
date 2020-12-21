package com.antra2;

public interface I1 extends I2{

	public void m1();
	
	public default void m2() {
		System.out.println("in default m2 method of I1");
	}
	
	public static void m3() {
		System.out.println("in static m3 of I1");
	}
}
