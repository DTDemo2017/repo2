package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.ProductDao;
import com.niit.model.Product;



@Controller
@Configuration
@ComponentScan("com.niit.dao")
public class HomeController {
	@Autowired 
	  ProductDao productDao;
	  @RequestMapping("/Index")  
	    public ModelAndView index(){  
	        return new ModelAndView("Index");  
	  }
	
	@RequestMapping("/Home")
	public ModelAndView goToHome()
	{
		ModelAndView mv= new ModelAndView("Home");
	    mv.addObject("message", "Thank you for visiting Shopping Cart");	
	    return mv;
		
}
	
	@RequestMapping("/LoginPage")
	public String LoginPage(Model model)
		{
		model.addAttribute("isUserClickedLogin", "true");
		System.out.println("User clicked Login link");
		return "Home";
		}
	
	@RequestMapping("/RegistrationPage")
	public String RegistrationPage(Model model)
	{
		model.addAttribute("isUserClickedRegister", "true");
		System.out.println("User clicked Registration link");
		return "Home";
	}
	
	 @RequestMapping("/ProductForm")  
	    public ModelAndView showform(){  
	        return new ModelAndView("ProductForm","command",new Product());  
	    } 
	 
	 @RequestMapping(value="/save",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("product") Product product){  
	    	productDao.addProduct(product);
	        return new ModelAndView("redirect:/ViewProduct");
	    }  
	 
	 @RequestMapping("/ViewProduct")  
	    public ModelAndView viewproduct(){  
	        List<Product> list=productDao.getAllProduct();
	        return new ModelAndView("ViewProduct","list",list);  
	    } 
	 
	 @RequestMapping(value="/EditProduct/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        Product product=productDao.getProductById(id);  
	        return new ModelAndView("ProductEditForm","command",product);  
	    }  
	 
	 @RequestMapping(value="/EditSave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("product") Product product){  
	    	productDao.updateProduct(product);
	        return new ModelAndView("redirect:/ViewProduct");  
	    }  
	 
	 @RequestMapping(value="/DeleteProduct/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){ 
	    	System.out.println("delete is called");
	       productDao.deleteProduct(id);
	        return new ModelAndView("redirect:/ViewProduct");  
	    }  

}
