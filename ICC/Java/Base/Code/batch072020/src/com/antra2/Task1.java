package com.antra2;

import java.util.concurrent.Callable;

public class Task1 implements Callable<String> {

	int i;
	public Task1(int i) {
		this.i=i;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Thread"+i;
	}

}
