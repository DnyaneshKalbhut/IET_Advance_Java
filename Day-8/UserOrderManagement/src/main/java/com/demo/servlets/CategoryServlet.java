package com.demo.servlets;

import java.io.IOException;
import java.util.List;

import com.demo.beans.Category;
import com.demo.services.ProductService;
import com.demo.services.ProductServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps=new ProductServicesImpl();
        List<Category> clist=ps.getAllCategory();
    	request.setAttribute("clist",clist);
        RequestDispatcher rd=request.getRequestDispatcher("categorypage.jsp");
        rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   doPost(request,response);
		}

}
