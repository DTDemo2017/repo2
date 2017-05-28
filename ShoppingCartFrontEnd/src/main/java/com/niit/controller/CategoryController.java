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

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Product;



@Controller
public class CategoryController {
	
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	//create category
		//fetch all categories
		//delete category
		//update category
		
		@Autowired  CategoryDAO categorydAO;
		
		@Autowired  Category category;
		
		@Autowired  ProductDAO productDAO;
		
		@Autowired  Product product;
		
		
		@Autowired HttpSession session;
		
		
		
		//@RequestMapping("/manage_category_add")
		@RequestMapping("/manage_category_add")
		public ModelAndView  createCategory(@RequestParam("categoryid") String categoryid, 
				@RequestParam("categoryname") String categoryname,  @RequestParam("categorydescription") String categorydescription)
		{
			
			log.debug("Starting of the method manageCategories");
			
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setCategorydescription(categorydescription);
			
			ModelAndView mv = new ModelAndView("redirect:/manageCategories");
			
			mv.addObject("isAdminClickedCategories", "true");
			mv.addObject("isAdmin", "true");
			
			//Before calling save method, check whether the category id already exist in db or not
			
			//if it is does not exist, then only call save method
			
			if (categorydAO.getCategoryByCategoryID(categoryid) !=null)
			{
				//category already exist
				mv.addObject("message", "Category already exists with this id " +categoryid);
				return mv;
				
			}
			else  // actualy else is not required if return statement is there in if condition
			{
				categorydAO.save(category);
				mv.addObject("message", "Category created successfuly ");
			}
			
			/*session.setAttribute("categoryList",categorydAO.list());
			session.setAttribute("category", category);*/
			
			log.debug("End of the method manageCategories");
			
			return mv;
			
		}	
	
		
		@RequestMapping("/manage_category_delete/{categoryid}")
		public ModelAndView deleteCategory(@PathVariable("categoryid") String categoryid)
		{
		
			
			log.debug("Starting of the method deleteCategory");
			log.debug("You are going to delete " + categoryid);
			ModelAndView mv = new ModelAndView("redirect:/manageCategories");
			
			//check whether products are there for this category or not
			int size = productDAO.getAllProductsByCategoryID(categoryid).size();
			if(size!=0)
			{
				log.debug("Few products are there under this category. you can not delete");
				 mv.addObject("message", size+ " products are there under category" + categoryid +". you can not delete");
				 session.setAttribute("message", size+ " products are there under category" + categoryid +". you can not delete");
				 return mv;
			}
			 if( categorydAO.delete(categoryid))
			 {
				 mv.addObject("message", "successfully deleted the category");
			 }
			 else
			 {
				 mv.addObject("message", "Not able to delete the category");
			 }
			 
				/*session.setAttribute("categoryList", categorydAO.list());
				session.setAttribute("category", category);*/
				
			
				log.debug("Ending of the method deleteCategory");
			 
			 return mv;
}
		//http://localhost:8080/ShoppingCartFrontEnd/manage_category_edit/C01
           @RequestMapping("/manage_category_edit/{categoryid}")
           public ModelAndView editCategory(@PathVariable("categoryid") String categoryid)
           {
        	   log.debug("Starting of the method editCategory");
       		
       		   log.debug("Going to edit the category : " + categoryid);
        	   category=categorydAO.getCategoryByCategoryID(categoryid);
            //We have to store selected category details in another instance ModelAndView
        	ModelAndView mv=new ModelAndView("redirect:/manageCategories");
        	session.setAttribute("selectedCategory", category);
        		mv.addObject("selectedCategory", category);
        		log.debug("Ending of the method editCategory");
        	   return mv;
           }
           
           
         //@RequestMapping("/maage_category_edit/manage_category_update")
       	@RequestMapping("/manage_category_update")
       	public ModelAndView  updateCategory(@RequestParam("categoryid") String categoryid, 
       			@RequestParam("categoryname") String categoryname,  @RequestParam("categorydescription") String categorydescription)
       	{
       		
       		log.debug("Starting of the method updateCategory");
       		category.setCategoryid(categoryid);
       		category.setCategoryname(categoryname);
       		category.setCategorydescription(categorydescription);
       		
       		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
       		
       		/*mv.addObject("isAdminClickedCategories", "true");
       		mv.addObject("isAdmin", "true");*/
       		
       		//Before calling save method, check whether the category id already exist in db or not
       		
       		//if it is does not exist, then only call save method
       		
       		if (categorydAO.getCategoryByCategoryID(categoryid) ==null)
       		{
       			//category does not exist
       			mv.addObject("message", "Category does not exist with the id " +categoryid);
       			return mv;
       			
       		}
       		else  // actualy else is not required if return statement is there in if condition
       		{
       			categorydAO.update(category);
       			mv.addObject("message", "Category updated successfuly ");
       		}
       		
       		
       	/*	session.setAttribute("categoryList", categorydAO.list());
       		session.setAttribute("category", category);
       		*/
       	
       		
       		log.debug("End of the method updateCategory");
       		
       		return mv;
       		
       		
       		
       	}
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
       	
           
           
          
}