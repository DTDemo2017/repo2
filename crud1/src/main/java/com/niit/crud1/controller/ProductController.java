package com.niit.crud1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.niit.crud1.dao.ProductsDao;
import com.niit.crud1.model.Products;

@Controller 
public class ProductController {
	@Autowired 
	  ProductsDao productsDao;
	  @RequestMapping("/index")  
	    public ModelAndView index(){  
	        return new ModelAndView("index");  

}
	  @RequestMapping("/productsform")  
	    public ModelAndView showform(){  
	        return new ModelAndView("productsform","command",new Products());  
	    } 
	  
	  /*It saves object into database. The @ModelAttribute puts request data 
	     *  into model object. You need to mention RequestMethod.POST method  
	     *  because default request is GET*/  
	    @RequestMapping(value="/save",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("products") Products products){  
	    	productsDao.addProducts(products);
	        return new ModelAndView("redirect:/viewproducts");//will redirect to viewproducts request mapping  
	    }  
	    
	    /* It provides list of products in model object */  
	    @RequestMapping("/viewproducts")  
	    public ModelAndView viewproducts(){  
	        List<Products> list=productsDao.getAllProducts();
	        return new ModelAndView("viewproducts","list",list);  
	    }  
	    
	    /* It displays object data into form for the given id.  
	     * The @PathVariable puts URL data into variable.*/  
	    @RequestMapping(value="/editproducts/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        Products products=productsDao.getProductsById(id);  
	        return new ModelAndView("productseditform","command",products);  
	    }  
	    
	    /* It updates model object. */  
	    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("products") Products products){  
	    	productsDao.updateProducts(products);
	        return new ModelAndView("redirect:/viewproducts");  
	    }  
	    
	    /* It deletes record for the given id in URL and redirects to /viewproducts */  
	    @RequestMapping(value="/deleteproducts/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){ 
	    	System.out.println("delete is called");
	       productsDao.deleteProducts(id);
	        return new ModelAndView("redirect:/viewproducts");  
	    }  
	}

