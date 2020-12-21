package com.antra2;

public interface I2 {

	public void m1();
	
	public default void m2() {
		System.out.println("in default m2 method of I2");
	}
}
