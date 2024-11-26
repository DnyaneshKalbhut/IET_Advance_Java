package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/showprod")
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.setContentType("text/html");
           PrintWriter out = response.getWriter();
           ProductService ps = new ProductServiceImpl();
           List<Product> plist =  ps.getAllProduct();
           if(plist!=null) {
   			out.println("<table border=2><tr><th>Product Id</th><th>Name</th><th>Qty</th><th>price</th><th>expiry date</th><th>Catid</th><th>Actions</th></tr>");
            for(Product p : plist ) {
            	out.println("<tr><td>"+ p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPrice()+"</td><td>"+p.getQty()+"</td>");
                String dt = p.getExpdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                out.println("<td>"+dt+"</td><td>"+p.getCid()+"</td>");
            	out.println("<td><a href='#'>edit</a>/<a href='#'>delete</a></td></tr>");
            }          
            out.println("</table>");
           }
	}

}
