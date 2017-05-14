package com.niit.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.MycartDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.domain.Mycart;
import com.niit.shoppingcartbackend.domain.Product;

@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private MycartDAO mycartDAO;

	@Autowired
	private Mycart mycart;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/mycart", method = RequestMethod.GET)
	public String mycart(Model model) {
		log.debug("Starting of the method mycart");
		model.addAttribute("mycart", new Mycart());
		// get the logged-in user id
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");

		/*if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}*/
		if(loggedInUserid!=null)
		{

		int cartSize = mycartDAO.list(loggedInUserid).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", mycartDAO.list(loggedInUserid));
			model.addAttribute("totalAmount", mycartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("displayCart", "true");
			model.addAttribute("cart",mycart);

		}
		
		}
		log.debug("Ending of the method mycart");
		return "/Home";
	}

	// For add and update myCart both
	@RequestMapping(value = "/mycart/add/{productid}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("productid") String productid) {
		log.debug("Starting of the method addToCart");
		// get the product based on product id
		Product product = productDAO.get(productid);
		mycart.setPrice(product.getProductprice());
		mycart.setProductname(product.getProductname());
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
		}
		mycart.setUserid(loggedInUserid);
		//It is not required if you given default value while creating the table
		mycart.setStatus('N'); // Status is New. Once it is dispatched, we can
								// changed to 'D'
		mycart.setQuantity(1);
		mycart.setDateadded(newDate(System.currentTimeMillis()));
		
		//To get sequence number, you can do programmatically in DAOImpl
		//myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		//check same product is added earlier.
		
		/*if(mycartDAO.getmycart(loggedInUserid, mycart.getProductname()) !=null)
		{
			//increase the quantity and update it.
			 int presentQuantity = mycartDAO.getQuantity(loggedInUserid, mycart.getProductname());
					 mycart.setQuantity(presentQuantity + 1);	 
			 mycartDAO.update(mycart);
					 
		}
		else
		{
			mycartDAO.save(mycart);
			
			
		}*/
		mycartDAO.save(mycart);
	
		// return "redirect:/views/home.jsp";

		ModelAndView mv = new ModelAndView("redirect:/Home");
		mv.addObject("successMessage", " Successfuly added the product to mycart");
		log.debug("Ending of the method addToCart");
		return mv;

	}

	private Date newDate(long currentTimeMillis) {
		// TODO Auto-generated method stub
		return null;
	}


}
