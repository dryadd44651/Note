package com.antra1;

public class Animal {

	int animalId;
	String animalName;
	
	/*public Animal() {
		System.out.println("in animal constructor");
	}*/
	static{
		System.out.println("static block");
	}
	{
		System.out.println("in instance block");
	}
	public Animal(int aId,String animalName) {
		System.out.println("in constructor");
		this.animalId=aId;
		this.animalName=animalName;
	}
	
	public void m1() {
		System.out.println("in m1 method");
	}
	
}
