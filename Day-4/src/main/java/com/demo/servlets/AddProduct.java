package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("pname");
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price = Double.parseDouble(request.getParameter("price"));
		String dt = request.getParameter("expdate");
		LocalDate ltd = LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		Product p = new Product(id,name,qty,price,ltd,cid);
		ProductService ps = new ProductServiceImpl();
		ps.insertProduct(p);
		RequestDispatcher rd = request.getRequestDispatcher("showprod");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
