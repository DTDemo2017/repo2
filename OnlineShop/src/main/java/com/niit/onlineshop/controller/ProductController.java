package com.niit.onlineshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshop.dao.CategoryDao;
import com.niit.onlineshop.dao.ProductDao;
import com.niit.onlineshop.model.Product;





@Controller
public class ProductController {
	@Autowired CategoryDao categoryDao;
	 @Autowired ProductDao productDao;
	 
	  @RequestMapping("/index1")  
	    public ModelAndView index1(){  
	        return new ModelAndView("index1");  
	    } 
	  
	@RequestMapping("/productsform")  
   public ModelAndView showform(){  

	       ModelAndView mv=new ModelAndView("productsform","command",new Product());  
	       mv.addObject("categoryList",categoryDao.list());
	       
	      
	       return mv;    
   } 
	
	 /*It saves object into database. The @ModelAttribute puts request data 
    *  into model object. You need to mention RequestMethod.POST method  
    *  because default request is GET*/  
   @RequestMapping(value="/save",method = RequestMethod.POST)  
   public ModelAndView save(@ModelAttribute("product") Product product , HttpServletRequest request, 
			@RequestParam("file") MultipartFile file){  
   	
   	///////////////////////////////
   	
		byte fileBytes[];
		FileOutputStream fos = null;
		
		String fileName = "";
		String productImage = "";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String un = product.getProductName();
		if (file != null){
			fileName = realContextPath + "/resources/img/" + un + ".jpg";
			productImage = "resources/img/" + un + ".jpg";
			System.out.println("===" + fileName + "===");
			File fileobj = new File(fileName);
			try{
				fos = new FileOutputStream(fileobj);
				fileBytes = file.getBytes();
				fos.write(fileBytes);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		/*String sid=product.getSupplier().getId();
		String cid=product.getCategory().getId();*/
		
			
		
		/*Supplier ss=supplierDAO.get(sid);
		Category cc=categoryDAO.get(cid);
		
		product.setCategory(cc);
		product.setSupplier(ss);*/
		
		  	
   	
   	
   	//////////////////////////////
   	
   	
   	
   	
   	
		product.setProductImage(productImage);
   	productDao.addProduct(product);
       return new ModelAndView("redirect:/viewproducts");//will redirect to viewproducts request mapping  
   }  
   
   /* It provides list of products in model object */  
   @RequestMapping("/viewproducts")  
   public ModelAndView viewproducts(){  
       List<Product> list=productDao.getAllProducts();
       return new ModelAndView("viewproducts","list",list);  
   } 
   
   
   
   
   @RequestMapping(value="/editproducts/{id}")  
   public ModelAndView edit1(@PathVariable int id){  
	   Product product=productDao.listByProductId(id);  
       ModelAndView mv=new ModelAndView("productseditform","command",product);  
       mv.addObject("categoryList",categoryDao.list());
       
       mv.addObject("photo",product.getProductImage());
       return mv;  
   }  
   
   
   /* It updates model object. */  
   @RequestMapping(value="/editsave",method = RequestMethod.POST)  
   public ModelAndView editsave(@ModelAttribute("product") Product product , HttpServletRequest request, 
			@RequestParam("file") MultipartFile file){  
   	
///////////////////////////////
   	if (file.getSize()!=0)
   		
   	{
   		
   		System.out.println("uiuiuiuiuiuiu"+ file.getSize());
byte fileBytes[];
FileOutputStream fos = null;

String fileName = "";
String productImage = "";
ServletContext context = request.getServletContext();
String realContextPath = context.getRealPath("/");
String un = product.getProductName();
if (file != null){
	System.out.println(" file not null");
fileName = realContextPath + "/resources/img/" + un + ".jpg";
productImage = "resources/img/" + un + ".jpg";
System.out.println("===" + fileName + "===");
File fileobj = new File(fileName);
try{
fos = new FileOutputStream(fileobj);
fileBytes = file.getBytes();
fos.write(fileBytes);
fos.close();
} catch(Exception e) {
e.printStackTrace();
}
}

/*String sid=product.getSupplier().getId();
String cid=product.getCategory().getId();*/

product.setProductImage(productImage);	
   	}
/*Supplier ss=supplierDAO.get(sid);
Category cc=categoryDAO.get(cid);

product.setCategory(cc);
product.setSupplier(ss);*/




//////////////////////////////
   	
   	
   	
   	
   	
   	
   	
   	
   	productDao.updateProduct(product);
       return new ModelAndView("redirect:/viewproducts");  
   }  
   
   /* It deletes record for the given id in URL and redirects to /viewproducts */  
   @RequestMapping(value="/deleteproducts/{id}",method = RequestMethod.GET)  
   public ModelAndView delete(@PathVariable int id){ 
   	System.out.println("delete is called");
      productDao.deleteProducts(id);
       return new ModelAndView("redirect:/viewproducts");  
   }  

}