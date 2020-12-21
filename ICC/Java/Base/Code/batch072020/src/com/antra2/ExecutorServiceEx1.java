package com.antra2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		ExecutorService ex=Executors.newFixedThreadPool(5);//t1,t2,t3,t4,t5
		
		ArrayList<Callable<String>> al=new ArrayList();
		al.add(new Task1(1));
		al.add(new Task1(2));
		al.add(new Task1(3));
		al.add(new Task1(4));
		al.add(new Task1(5));
		al.add(new Task1(6));
		al.add(new Task1(7));
		al.add(new Task1(8));
		al.add(new Task1(9));
		al.add(new Task1(10));
			
	List<Future<String>> li=ex.invokeAll(al);
		for(Future f:li) {
			System.out.println(f.get());
		}
		ex.shutdown();
		/*ExecutorService ex=Executors.newSingleThreadExecutor();
		ex.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("in thread");
			}
		});
		ex.shutdown();*/
	}
}
