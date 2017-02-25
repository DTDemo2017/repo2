package com.niit.web1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.web1.model.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet () 
     */
    public AddProductServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String s1= request.getParameter("id");
		int id= Integer.parseInt(s1);
		String name= request.getParameter("name");
		String s3=  request.getParameter("price");
		double price= Double.parseDouble(s3);
		
		Product p= new Product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		
		PrintWriter pw= response.getWriter();
		
		pw.print("Id" +p.getId());
		pw.print("Name" +p.getName() );
		
	}

}
