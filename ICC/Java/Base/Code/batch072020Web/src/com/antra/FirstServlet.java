package com.antra;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession hsession=req.getSession();
		System.out.println(hsession.getAttribute("abc"));
		/*Cookie ck[]=req.getCookies();
		if(ck!=null) {
		for(Cookie ck1:ck) {
			System.out.println(ck1.getName());
			System.out.println(ck1.getValue());
		}
		}else {
			System.out.println("no cookies are available");
		}*/
		System.out.println("in first servlet service method");
	}

}
