package com.niit.onlineshop.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshop.dao.CategoryDao;
import com.niit.onlineshop.dao.ProductDao;
import com.niit.onlineshop.dao.UserDao;
import com.niit.onlineshop.model.User;



@Controller  
public class HomeController {
	 @Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 @Autowired 
	  UserDao userDao;
	 @RequestMapping("/home")  
	    public ModelAndView home(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 mv.addObject("msg", "Thank you for visiting Online Shop..");
		 
		 session.setAttribute("categoryList", categoryDao.list());
		 mv.addObject("categoryList", categoryDao.list());
	        return mv;  
	    } 
	 
	 @RequestMapping("/index")  
	    public ModelAndView index(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 session.setAttribute("categoryList", categoryDao.list());
		 mv.addObject("categoryList", categoryDao.list());
	        return mv;  
	    } 
	 
	
	 
	 @RequestMapping("/showProductsByCategory/{categoryId}")  
	    public ModelAndView showProductsByCategory(@PathVariable int categoryId ){  
		 System.out.println("cat id "+categoryId);
		 ModelAndView mv= new ModelAndView("products");
		 mv.addObject("productList", productDao.listByCategoryId(categoryId));
	        return mv;  
	    } 
	 
	 
	 @RequestMapping("/showProduct/{productId}")  
	    public ModelAndView showProduct(@PathVariable int productId ){  
		 
		 ModelAndView mv= new ModelAndView("product");
		 mv.addObject("product", productDao.listByProductId(productId));
	        return mv;  
	    } 
	 
	 @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
		public ModelAndView loginPage() {

			return new ModelAndView("loginPage");
		}


	 
	 
	 
}
