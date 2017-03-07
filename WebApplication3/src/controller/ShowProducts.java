package controller;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProducts
 */
@WebServlet("/ShowProducts")
public class ShowProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDao productDao= new ProductDaoImpl();
		ArrayList<Product> list= productDao.getAllProduct();
		
		request.setAttribute("productList", list);
		
		//dispatching
		
		RequestDispatcher r= request.getRequestDispatcher("products.jsp");
				
		r.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
