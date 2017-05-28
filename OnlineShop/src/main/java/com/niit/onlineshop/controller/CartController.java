package com.niit.onlineshop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshop.dao.CartDao;
import com.niit.onlineshop.dao.CartItemDao;
import com.niit.onlineshop.dao.ProductDao;
import com.niit.onlineshop.dao.UserDao;
import com.niit.onlineshop.model.Cart;
import com.niit.onlineshop.model.CartItem;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.User;

@Controller
public class CartController {
	 @Autowired ProductDao productDao;
	 
	 @Autowired UserDao userDao;
	 

	
	 
	 @Autowired CartDao cartDao;
	 
	 @Autowired CartItemDao cartItemDao;
	 
	 @RequestMapping(value="/cartItem",method = RequestMethod.POST)  
	   public ModelAndView CartItem(@ModelAttribute("cartItem") CartItem cartItem){
		   cartItem.setStatus("new");
		return new ModelAndView("redirect:/home");
	 }
	 
	 
	 @RequestMapping("/cart")
		public ModelAndView cart(){
			ModelAndView cart=new ModelAndView("cart");
			return cart;
	}



	 @RequestMapping("/cart/add/{pid}")
	 public ModelAndView add(@PathVariable int pid, Principal principal, HttpSession session){
		 ModelAndView mv = new ModelAndView("redirect:/cart/show");
		 String un = principal.getName();
		 System.out.println("logged in user "+un);
		 Product product = productDao.listByProductId( pid);
		 User u=userDao.getUsersById(un);
		 //Cart cart = cartDao.getCartByUserId(id);
		 Cart cart=u.getCart();//get the cart of the user
		 if(cart==null)  // if cart not present
		 {
			
			 Cart c = new Cart();//new cart if user has no cart
			 User user = userDao.getUsersById(un);
			 
			 c.setUser(user);
			 cartDao.saveOrUpdate(c);  // create a cart for the user
			 user.setCart(c);
			 userDao.editUsers(user);  //  update the user 
			 
                                                   // create a new cart item
			 CartItem cartItem = new CartItem();
			 cartItem.setCart(c);
			 cartItem.setProduct(product);
			 cartItem.setQuantity(1);
			 cartItem.setSubTotal(product.getProductPrice());
			 cartItem.setStatus("N");
			 cartItemDao.saveOrUpdate(cartItem);  // save the cart item
			 //updateCart(cartItem);
			 session.setAttribute("cart", cartItem.getCart());  //  create session variable to store the cart
			 
			 return mv;
		 }
		 
		 
		
		 
		//  cart already present
		 // get the existing cart items
		 List <CartItem> cartItems = cart.getCartItems();
		 
		 for(CartItem cartItem:cartItems)
		 {
                                                    ///  if the item that is added already in cart , update qty and subtotal
			if(cartItem.getProduct().getProductId()==pid)
			{
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setSubTotal(cartItem.getSubTotal()+product.getProductPrice());
				cartItemDao.saveOrUpdate(cartItem);
				//updateCart(cartItem);
				session.setAttribute("cart", cartItem.getCart());
				return mv;
			}
		 }
		  ///  if the item that is added not  in cart ,  create new item
		 CartItem item = new CartItem();
		 item.setCart(cart);
		 item.setProduct(product);
		 item.setQuantity(1);
		 item.setSubTotal(product.getProductPrice());
		 item.setStatus("N");

		 cartItemDao.saveOrUpdate(item);
		//updateCart(item);
		 session.setAttribute("cart", item.getCart());
		 return mv;
	}

	/*private void updateCart(CartItem cartItem1) {
		// TODO Auto-generated method stub
		
	}*/

	
	
	 @RequestMapping("/cart/show")
	 public ModelAndView showProduct(HttpSession session){
		 
		 ModelAndView mv= new ModelAndView("cart");
		 Cart cart= (Cart) session.getAttribute("cart");
		 if(cart==null)
		 {
			 mv.addObject("errMsg", "No Items in Cart");
		 }
		 else
		 {
			 mv.addObject("cartContent", cart.getCartItems());
			
		 }
		 return mv;
	 }
	 
	@RequestMapping("/deleteItems/{cartItemId}")
		public String removeCartItems(@PathVariable("cartItemId") Integer cartItemId, Model model, Principal username) {
			System.out.println("delete from cartitem method...");
			
			CartItem cartItem = cartItemDao.get(cartItemId);
			
			
			
			cartItemDao.delete(cartItem);
			
			
			
			return "redirect:/cart/show";
		}


}
