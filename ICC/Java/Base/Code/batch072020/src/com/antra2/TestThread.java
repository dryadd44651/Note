package com.antra2;

public class TestThread {

	public static void main(String[] args) {
		
		Calculate cl=new Calculate();
		
		ThreadEx1 t1=new ThreadEx1(cl);
		ThreadEx2 t2=new ThreadEx2(cl);
		t1.start();
		t2.start();
		
		
		/*ThreadEx2 th2=new ThreadEx2();
		Thread t2=new Thread(th2);
		t2.start();*/
		
		/*ThreadEx1 t1=new ThreadEx1();
		t1.start();*/
		/*ThreadEx1 t1=new ThreadEx1();
		t1.start();//15min
*/		
	}

}
