package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.domain.User;

@Controller
public class UserController {
	@Autowired UserDAO userDAO;
	@Autowired User user;
	
	//Gets user id and password from Login Page
	//send these values to userDAO.validate
	//Based on what they entered in Login Page they will navigate to Login.jsp or Home.jsp
	
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("userName") String id, @RequestParam("password") String password)
	
	{
		ModelAndView mv= new ModelAndView("/Home");
				{
			if(userDAO.validate(id, password)== true)
			{
				user= userDAO.get(id);
				mv.addObject("message", "Welcome" +user.getName());
			}
			else
			{
				mv.addObject("message", "Invalid credentials......please try again.");
			}
			
			return mv;
				}
	}

}
