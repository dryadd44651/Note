package net.antra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	

	public void service(HttpServletRequest servletRequest,HttpServletResponse servletResponse) throws ServletException, IOException {
		
		String name=servletRequest.getParameter("name");
		String password=servletRequest.getParameter("password");
		PrintWriter out=servletResponse.getWriter();
		servletRequest.getRequestDispatcher("link.html").include(servletRequest, servletResponse);  
		if(password.equals("1234")) {
			out.println("Welcome:"+name);
			Cookie ck=new Cookie("name",name);  
			servletResponse.addCookie(ck);  
			
		}else {
			
			 out.print("Sorry, username or password error!");  
	            servletRequest.getRequestDispatcher("login.html").include(servletRequest, servletResponse);  
		}
		
		out.close();
	}
}
