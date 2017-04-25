package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//http://localhost:8080/ShoppingCartFrontEnd/
		@RequestMapping("/")
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
