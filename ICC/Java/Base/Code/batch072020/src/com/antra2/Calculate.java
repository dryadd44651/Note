package com.antra2;

public class Calculate {
	
	public synchronized void printMul(int no) {
		for(int j=1;j<=5;j++) {
			System.out.println(no+"*"+j+"="+(no*j));
		}
	}

}
