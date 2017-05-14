package com.niit.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.domain.Category;



@Controller
public class AdminController {
	
	//SLF4J->Simple Logging Facade for Java
	private static Logger log=LoggerFactory.getLogger(AdminController.class);
	
    @Autowired  Category  category;
	
	@Autowired  HttpSession session;
	
	
	@RequestMapping("/manageCategories")
	
	
	public ModelAndView manageCategories()
	{
		log.debug("Starting of the method manageCategories");
		
		
		ModelAndView mv = new ModelAndView("Home");
		
		
		if(session.getAttribute("logedInUserID")== null)
		{
			//user is not logged in
			mv.addObject("message", "Please login to do this operation.");
			return mv;
		}
		//check whether the logged-in user role is admin or not
		if(session.getAttribute("role").equals("ROLE_USER"))
		{
			mv.addObject("message", "You are not admin.You cannot perform this operation.");
			return mv;
		}
		
		/*else if(session.getAttribute("role").equals("ROLE_ADMIN"))
		{mv.addObject("message", "You are  admin.You will perform this operation.");
		return mv;
		}*/	
			mv.addObject("isAdmin", "true");	
		
		mv.addObject("isAdminClickedCategories", "true");
		
		
		log.debug("End of the method manageCategories");
	    return mv;
		}
		
	@RequestMapping("/manageSupplier")
	public ModelAndView manageSuppliers()
	{
		log.debug("Starting of the method manageSuppliers");
		
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedSuppliers", "true");
		
		
		log.debug("End of the method manageSuppliers");
		return mv;
		
		
	}
	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts()
	{
		log.debug("Starting of the method manageProducts");
		
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedProducts", "true");
		
		log.debug("End of the method manageProducts");
		return mv;
		
		
	}


}
