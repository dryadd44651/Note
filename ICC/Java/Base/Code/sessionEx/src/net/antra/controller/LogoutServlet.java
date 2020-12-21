package net.antra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	public void service(HttpServletRequest servletRequest,HttpServletResponse servletResponse) throws IOException, ServletException {
		
		PrintWriter out=servletResponse.getWriter(); 
        
		servletRequest.getRequestDispatcher("link.html").include(servletRequest, servletResponse);  
		 
        HttpSession session=servletRequest.getSession();  
        session.invalidate();  
        
          
        out.print("You are successfully logged out!");  
          
        out.close();  
       
		
	}

}
