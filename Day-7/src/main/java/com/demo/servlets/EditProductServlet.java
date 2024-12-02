package com.demo.servlets;

import java.io.IOException;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editprod")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProductService pservice=new ProductServiceImpl();
		Product p=pservice.getById(pid);
		request.setAttribute("prod",p);
		RequestDispatcher rd=request.getRequestDispatcher("updateform.jsp");
		rd.forward(request, response);
		
	}

}
