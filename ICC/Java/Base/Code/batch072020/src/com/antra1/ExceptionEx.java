package com.antra1;

import java.util.Scanner;

public class ExceptionEx {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter i value:");
		int i=sc.nextInt();
		
		System.out.println("enter j value:");
		int j=sc.nextInt();
		
		int k=i/j;
		int m=i+j;
		
		System.out.println(k+":div");
		System.out.println(m+":add");
	}

}
