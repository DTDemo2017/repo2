package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Product;

@Controller
public class HomeController {
	
	//http://localhost:8080/ShoppingCartFrontEnd/
	
	@Autowired HttpSession session;
	
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
	
	
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
		
	
	@RequestMapping("/")
	public ModelAndView goToHome()
	{
			ModelAndView mv= new ModelAndView("Home");
		    mv.addObject("msg", "Thank you for visiting Shopping Cart");
		    
		    
		    
		    List<Category> categoryList= categoryDAO.list();
		    List<Product> productList= productDAO.list();
		    
		    
		    session.setAttribute("category", category);
		    
		    
		    
		    session.setAttribute("categoryList", categoryList);
		    
		    
		    session.setAttribute("product", product);
			session.setAttribute("productList", productDAO.list());
			
		    
		    
		 
		    return mv;
		 //return Home
			
	}
		
		@RequestMapping("/LoginPage")
		public String LoginPage(Model model)
			{
			model.addAttribute("isUserClickedLogin", "true");
			System.out.println("User clicked Login link");
			
			Long currentTime= System.currentTimeMillis();
			Date currentDate= new Date(currentTime);
			return "Home";
			}
			
			@RequestMapping("/Menu")
			public String Menu()
				{
				
				return "Menu";
				}
			
			@RequestMapping("/RegistrationPage")
			public String RegistrationPage(Model model)
			{
				model.addAttribute("isUserClickedRegister", "true");
				System.out.println("User clicked Registration link");
				return "Home";
				
			}
			
			
			

}
