package com.antra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionEx extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		HttpSession hsession=req.getSession(true);
		PrintWriter out=res.getWriter();
		out.println(hsession.getId());
		hsession.setAttribute("abc", "David");
		
		
		
	}
}
