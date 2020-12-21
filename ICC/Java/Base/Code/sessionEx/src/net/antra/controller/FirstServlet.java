package net.antra.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{

	public void service(HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		
		System.out.println("in first servlet");
		
	}
}
