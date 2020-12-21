package com.antra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String emp_id=req.getParameter("id");
		String emp_name=req.getParameter("name");
		String emp_sal=req.getParameter("sal");
		
		System.out.println(emp_id);
		System.out.println(emp_name);
		System.out.println(emp_sal);
		
		PrintWriter out=res.getWriter();
		out.println("you have entered");
		out.println(emp_id);
		out.println(emp_name);
		out.println(emp_sal);
	}

}
