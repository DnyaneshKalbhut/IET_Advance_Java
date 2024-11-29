package com.demo.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editproduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);
		ProductService pservice=new ProductServiceImpl();
		Product p=pservice.getById(pid);
		if(p!=null) {
			out.println("<form>");
			out.println("Product ID : <input type='text' id = 'pid' name='pid' value='"+p.getPid()+"' readonly>");
			out.println("Product Name : <input type='text' id= 'pname' name='pname' value='"+p.getPname()+">");
			out.println("Product Quantity : <input type='text' name='qty' id='qty' value='"+p.getQty()+"'>");
			out.println("Product Price:  <input type='text' name='price' id='price'value='"+p.getPrice()+"'>");
			String dt=p.getExpdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			out.println("Expiry date : <input type='text' name='expdate' id='expdate' value='"+dt+"'>");
			out.println("Category Id : <input type='text' name='cid' id='cid' value='"+p.getCid()+"'>");
			out.println("<button type='submit' name='btn' id='btn' value='add'>Update Product</button>");
			out.println("</form><br>");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
