package com.niit.onlineshop.controller;

import java.security.Principal;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshop.dao.BillingDao;
import com.niit.onlineshop.dao.CartDao;
import com.niit.onlineshop.dao.CartItemDao;
import com.niit.onlineshop.dao.UserDao;
import com.niit.onlineshop.model.User;
import com.niit.onlineshop.model.Billing;

import com.niit.onlineshop.model.CartItem;
@Controller
public class BillingController {
	
	@Autowired CartDao cartDao;
	@Autowired BillingDao billingDao;
	@Autowired UserDao userDao;
	
	@Autowired CartItemDao cartItemDao;

	@RequestMapping("/addBill")  
	public ModelAndView Billing(){  
	    return new ModelAndView("Billing","command",new Billing());  
	} 
	@RequestMapping("billingThanking")
	public ModelAndView BillingThanking(){
		ModelAndView BillingThanking=new ModelAndView("billingThanking");
		return BillingThanking;
	}
	@RequestMapping(value="/billing",method = RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute("billing") Billing billing ,Principal principal,HttpSession session ){  
				
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		String u=principal.getName();
				double d=(Double)session.getAttribute("tot");
				User user=userDao.getUsersById(u);
				int cart=user.getCart().getCartId();
				List<CartItem>  items=cartDao.getCartItemsByCartId(cart);
				
				for(CartItem i:items)
				{
					i.setStatus("Y");
					cartItemDao.saveOrUpdate(i);
				}
				
				
				billing.setUser(user);
				billing.setBillingAmount(d);
				
				
		Billing billing1=new Billing();
		
		billingDao.addBilling(billing);
	    return new ModelAndView("redirect:/billingThanking");
	}


	}
	


