package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.beans.Person;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String password=request.getParameter("passwd");
		String gender=request.getParameter("gender");
		String degree=request.getParameter("degree");
		String city=request.getParameter("city");
		String[] skills = request.getParameterValues("skill");
		LoginService ls = new LoginServiceImpl();
		
		Person p1 = new Person(fname,lname,gender,degree,skills,city);
		System.out.println("in servlet "+uname+"-------"+password);
		MyUser u1 = new MyUser(uname,password,"user");
		boolean status=ls.registerdetails(p1,u1);
		if(status) {
			//if registration is successful
			out.println("<h3>Registeration successfully done, Pls login</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}else {
			//registration is unsuccessful
			out.println("<h3>Registeration not done, Pls re-register</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
