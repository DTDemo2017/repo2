package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;

@Controller
public class SupplierController {
	private static  Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	//create supplier
			//fetch all suppliers
			//delete supplier
			//update supplier
	
	@Autowired  SupplierDAO supplierdAO;
	
	@Autowired  Supplier supplier;
	
	@Autowired  ProductDAO productDAO;
	
	@Autowired  Product product;
	
	
	@Autowired HttpSession session;
	
	
	//@RequestMapping("/manage_supplier_add")
			@RequestMapping("/manage_supplier_add")
			public ModelAndView  createSupplier(@RequestParam("supplierid") String supplierid, 
					@RequestParam("suppliername") String suppliername,  @RequestParam("supplieraddress") String supplieraddress)
			{
				
				log.debug("Starting of the method manageSuppliers");
				
				supplier.setSupplierid(supplierid);
				supplier.setSuppliername(suppliername);
				supplier.setSupplieraddress(supplieraddress);
				
				ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
				
				mv.addObject("isAdminClickedSuppliers", "true");
				mv.addObject("isAdmin", "true");
				
				//Before calling save method, check whether the supplier id already exist in db or not
				
				//if it is does not exist, then only call save method
				
				if (supplierdAO.getSupplierBySupplierID(supplierid) !=null)
				{
					//supplier already exist
					mv.addObject("message", "Supplier already exists with this id " +supplierid);
					return mv;
					
				}
				else  // actually else is not required if return statement is there in if condition
				{
					supplierdAO.save(supplier);
					mv.addObject("message", "Supplier created successfuly ");
				}
				
				/*session.setAttribute("supplierList",supplierdAO.list());
				session.setAttribute("supplier", supplier);*/
				
				log.debug("End of the method manageSuppliers");
				
				return mv;
				
			}	
		
			
			@RequestMapping("/manage_supplier_delete/{supplierid}")
			public ModelAndView deleteSupplier(@PathVariable("supplierid") String supplierid)
			{
			
				
				log.debug("Starting of the method deleteSupplier");
				log.debug("You are going to delete " + supplierid);
				ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
				
				//check whether products are there for this supplier or not
				int size = productDAO.getAllProductsBySupplierID(supplierid).size();
				if(size!=0)
				{
					log.debug("Few products are there under this supplier. you can not delete");
					 mv.addObject("message", size+ " products are there under supplier" + supplierid +". you can not delete");
					 session.setAttribute("message", size+ " products are there under supplier" + supplierid +". you can not delete");
					 return mv;
				}
				 if( supplierdAO.delete(supplierid))
				 {
					 mv.addObject("message", "successfully deleted the supplier");
				 }
				 else
				 {
					 mv.addObject("message", "Not able to delete the supplier");
				 }
				 
					/*session.setAttribute("supplierList", supplierdAO.list());
					session.setAttribute("supplier", supplier);*/
					
				
					log.debug("Ending of the method deleteSupplier");
				 
				 return mv;
	}
			//http://localhost:8080/ShoppingCartFrontEnd/manage_supplier_edit/S01
	           @RequestMapping("/manage_supplier_edit/{supplierid}")
	           public ModelAndView editSupplier(@PathVariable("supplierid") String supplierid)
	           {
	        	   log.debug("Starting of the method editSupplier");
	       		
	       		   log.debug("Going to edit the supplier : " + supplierid);
	        	   supplier=supplierdAO.getSupplierBySupplierID(supplierid);
	            //We have to store selected supplier details in another instance ModelAndView
	        	ModelAndView mv=new ModelAndView("redirect:/manageSuppliers");
	        	session.setAttribute("selectedSupplier", supplier);
	        		mv.addObject("selectedSupplier", supplier);
	        		log.debug("Ending of the method editSupplier");
	        	   return mv;
	           }
	           
	           
	         //@RequestMapping("/maage_supplier_edit/manage_supplier_update")
	       	@RequestMapping("/manage_supplier_update")
	       	public ModelAndView  updateSupplier(@RequestParam("supplierid") String supplierid, 
	       			@RequestParam("suppliername") String suppliername,  @RequestParam("supplieraddress") String supplieraddress)
	       	{
	       		
	       		log.debug("Starting of the method updateSupplier");
	       		supplier.setSupplierid(supplierid);
	       		supplier.setSuppliername(suppliername);
	       		supplier.setSupplieraddress(supplieraddress);
	       		
	       		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
	       		
	       		/*mv.addObject("isAdminClickedsuppliers", "true");
	       		mv.addObject("isAdmin", "true");*/
	       		
	       		//Before calling save method, check whether the supplier id already exist in database or not
	       		
	       		//if it is does not exist, then only call save method
	       		
	       		if (supplierdAO.getSupplierBySupplierID(supplierid) ==null)
	       		{
	       			//supplier does not exist
	       			mv.addObject("message", "Supplier does not exist with the id " +supplierid);
	       			return mv;
	       			
	       		}
	       		else  // actualy else is not required if return statement is there in if condition
	       		{
	       			supplierdAO.update(supplier);
	       			mv.addObject("message", "Supplier updated successfuly ");
	       		}
	       		
	       		
	       	/*	session.setAttribute("supplierList", supplierdAO.list());
	       		session.setAttribute("supplier", supplier);
	       		*/
	       	
	       		
	       		log.debug("End of the method updateSupplier");
	       		
	       		return mv;
	       		
	       		
	       		
	       	}
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	
	       	

}
