package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validate")
public class validateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			String uname=request.getParameter("uname");
			String pass=request.getParameter("passwd");
			LoginService ls= new LoginServiceImpl();
			MyUser user= ls.getUser(uname,pass);
			if(user!=null && user.getRole().equals("user")) {
//				out.println("login success");
				RequestDispatcher rd=request.getRequestDispatcher("categories");
				rd.forward(request, response);
			}else {
//				out.println("invalid Login");
				RequestDispatcher rd=request.getRequestDispatcher("loginpage.jsp");
				rd.include(request, response);
			}
			
	}

}
