package com.antra;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	public void init() {
		System.out.println("in init method");
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println("in second servlet");
	}

	public void destroy() {
		System.out.println("in destroy method");
	}
}
