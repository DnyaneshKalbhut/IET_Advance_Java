package com.demo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.CartItem;
import com.demo.beans.Product;
import com.demo.services.ProductServicesImpl;
import com.demo.services.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet(name = "AddOrShowCart", urlPatterns = { "/addToCart" })
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btn");
		switch(btn) {
		case "add":
			//retrieve cart from session object if exists
			HttpSession sess=request.getSession();
			List<CartItem> clist=(List<CartItem>) sess.getAttribute("cart");
			//create a new list if the cart does not exists
			if(clist==null) {
				clist=new ArrayList<>();
			}
			String[] parr=request.getParameterValues("prod");
			ProductService pservice=new ProductServicesImpl();
			for(String id:parr) {
					Product p1=pservice.getById(Integer.parseInt(id));
					System.out.println("p"+id+"---->"+request.getParameter("p"+id));
					int ordQty=Integer.parseInt(request.getParameter("p"+id));
					if(p1.getQty()>ordQty) {
						CartItem c=new CartItem(p1.getPid(),p1.getPname(),ordQty,p1.getPrice()); //,"added","ok");
						clist.add(c);
					}else {
						CartItem c=new CartItem(p1.getPid(),p1.getPname(),ordQty,p1.getPrice()) ;//," Not added","insuffitient stock pls select qyty <="+p1.getQty());
						clist.add(c);
					}
			}
			System.out.println(clist);
			sess.setAttribute("cart",clist);
			RequestDispatcher rd=request.getRequestDispatcher("categories");
			rd.forward(request, response);
		break;
		
		case "show":
			rd=request.getRequestDispatcher("showcart.jsp");
			rd.forward(request, response);
		break;
	}

}
}
