package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
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
		String s2= request.getParameter("price");
		float price= Float.parseFloat(s2);
		
		Product p= new Product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		
		//attach the object p to the request object
		request.setAttribute("myProduct", p);
		
		//create object of request dispatcher to dispatch show_product.jsp
		RequestDispatcher rd= request.getRequestDispatcher("show_product.jsp");
		
		//dispatch
		rd.forward(request, response);
	}
	
	public String getServletInfo(){
		return "Short description" ;
	} //</editor-fold>
	}


