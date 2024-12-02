package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//import org.apache.jasper.compiler.Node.ForwardAction;

import com.demo.beans.Product;
import com.demo.services.ProductService;
import com.demo.services.ProductServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class findProductServlet
 */
@WebServlet("/getProduct")
public class findProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("tex/html");
	    PrintWriter out = response.getWriter();
	    ProductService pservice=new ProductServicesImpl();
	    int cid =Integer.parseInt(request.getParameter("cid"));
	    List<Product> plist=pservice.getProductById(cid);
	    if(plist!=null) {
	    	request.setAttribute("plist", plist);
	    	RequestDispatcher rd=request.getRequestDispatcher("showProduct.jsp");
	    			rd.forward(request, response);
	    }else {
	    	RequestDispatcher rd=request.getRequestDispatcher("/categories");
			rd.include(request, response);
	    }
	}
	
}
