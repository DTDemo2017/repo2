package com.niit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshop.dao.CartDao;
import com.niit.onlineshop.dao.UserDao;
import com.niit.onlineshop.model.Cart;
import com.niit.onlineshop.model.User;



@Controller  

public class UserController {
	 @Autowired 
	 UserDao  usersDao;
	 @Autowired
	 CartDao cartDao;
	 
	
	@RequestMapping("/register")  
    public ModelAndView showform(){  
        return new ModelAndView("usersform","command",new User()); 
        
        
    } 
	
	 
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("user") User user){  
		
		String s1=user.getPassword();
		String s2=user.getConfirmPassword();
		
		
		if(s1.compareTo(s2)!=0)
			
		{
			ModelAndView mv= new ModelAndView("usersform");
			mv.addObject("command", user);
			mv.addObject("error","Password and confirm password do not match");
			return mv;
			
		}
		Cart c=new Cart();
		cartDao.saveOrUpdate(c);
		System.out.println("cart id "+c.getCartId());
		user.setCart(c);
		ModelAndView mv= new ModelAndView("home");
    	if(usersDao.addUsers(user))
    	{
    	c.setUser(user);
    	cartDao.saveOrUpdate(c);
    	mv.addObject("msg1","You have successfully registered.");
    	}
    	else
    	{
    		mv.addObject("errormsg","Registration Failed !!!!.");
    	}
        //return new ModelAndView("redirect:/home");//will redirect to loginPage request mapping  
    	
        
        return mv;
    }  
    
	
}
