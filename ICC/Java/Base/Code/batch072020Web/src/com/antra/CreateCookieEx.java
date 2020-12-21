package com.antra;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookieEx extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		Cookie cookie1=new Cookie("Employee2","Tom");
		Cookie cookie2=new Cookie("Employee1","Chen");
		
		res.addCookie(cookie1);
		res.addCookie(cookie2);
	}
}
