package com.niit.shoppingcart.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDao;
import com.niit.shoppingcart.dao.ProductDao;

@Controller
public class CategoryController {
	@Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 
	 
	 @RequestMapping("/showProductsByCategory/{categoryId}")  
	    public ModelAndView showProductsByCategory(@PathVariable int categoryId ){  
		 System.out.println("cat id "+categoryId);
		 ModelAndView mv= new ModelAndView("products");
		 mv.addObject("productList", productDao.listByCategoryId(categoryId));
	        return mv;  
	    } 
}
