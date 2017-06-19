package com.niit.shoppingcart.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDao;
import com.niit.shoppingcart.dao.ProductDao;



@Controller  
public class HomeController {
	 @Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 @RequestMapping("/home")  
	    public ModelAndView index(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 session.setAttribute("categoryList", categoryDao.list());
		 mv.addObject("categoryList", categoryDao.list());
	        return mv;  
	    } 
	 
	 @RequestMapping("/home1")  
	    public ModelAndView index1(){  
		 ModelAndView mv= new ModelAndView("home_with_slider");
		 mv.addObject("productList", productDao.list());
	        return mv;  
	    } 
	 
	
	 
	 
	
	 
	 
	 
	 
}
