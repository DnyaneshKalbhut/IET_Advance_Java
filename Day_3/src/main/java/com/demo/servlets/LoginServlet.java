package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	 	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String uname = req.getParameter("uname");
		String passwd=req.getParameter("passwd");
		if(uname.equals("admin1") && passwd.equals("admin")){
			out.println("<h1>Login successful!!!</h1>");
			
				
		}else {
			out.println("<h1>Login unsuccessful!!!</h1>");
		}
	}
	

}
