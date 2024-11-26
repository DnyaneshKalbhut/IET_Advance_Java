package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.services.LoginServiceImpl;
import com.demo.beans.MyUser;
import com.demo.services.LoginService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validatedata")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//send credentials for validation
		String name = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		LoginService ls = new LoginServiceImpl();
		
	 MyUser user =ls.validateUser(name,passwd) ;
	 if(user!=null && user.getRole().equals("admin")) {
		 RequestDispatcher rd = request.getRequestDispatcher("showprod");
		 rd.forward(request, response);
	 }else {
		 out.println("<h1>Wrong Credential</h1>");
		 RequestDispatcher rd =request.getRequestDispatcher("login.html");
		 rd.include(request, response);
		
	 }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
