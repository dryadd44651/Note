package com.antra1;

public class Sample {//identifier
	
	int i=10;
	
	public void sampleM1() {
		System.out.println(i);
	}
	
	public static void main(String[] args) {//identifier
		
		
		Sample sm=new Sample();
		System.out.println(sm.i);
		sm.sampleM1();
		
		Person p=new Person();
		System.out.println(p.pId);
		p.pId=67;
		System.out.println(p.pId);

		Person p2=new Person();
		System.out.println(p2.pId);
		p2.m1();
		
		/*Sample sm=new Sample();
		System.out.println(sm.i);
		sm.i=90;
		System.out.println(sm.i);*/
		
	/*	int i[]=new int[3];
		i[0]=12;
		i[1]=78;
		i[2]=67;*/
		
		/*for(int j=0;j<i.length;j++) {
			System.out.println(i[j]);
		}*/

		/*for(int k:i) {
			System.out.println(k);
		}
		*/
		/*
		boolean bool=true;//no size// no range
		char ch='a';//2 bytes//single character
		
		float f=56.5f;//5 to 6 decimal points//4 bytes
		double d=76.78;//14 to 15 decimal points//8 bytes
		
		byte b=127;//-128 to 127 //1 byte//
		System.out.println(b);
		short s=32767;//-32768 to 32767//2 bytes 
		int i=10;//-2^31 to (2^31)-1//4 bytes
		long l=98;//-2^63 to (2^63)-1//8 bytes 
*/		
		
		
		
		/*int i=10;//identifier
		//a to z, A to Z, 0 to 9, _, $
*/		
		
		
	}

}
