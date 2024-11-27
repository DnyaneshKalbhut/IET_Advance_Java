package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteProd")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 int pid=Integer.parseInt(request.getParameter("pid"));
//		 System.out.println("Piddddd : " + pid);
			ProductService pservice=new ProductServiceImpl();
			boolean status=pservice.deletById(pid);
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
