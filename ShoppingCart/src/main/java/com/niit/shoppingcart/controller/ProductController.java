package com.niit.shoppingcart.controller;

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


import com.niit.shoppingcart.dao.CategoryDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Category;
@Controller
public class ProductController {
	@Autowired 
	  CategoryDao categoryDao;
	 @Autowired 
	 ProductDao productDao;
	 
	 @RequestMapping("/showProduct/{productId}")  
	    public ModelAndView showProduct(@PathVariable int productId ){  
		 
		 ModelAndView mv= new ModelAndView("product");
		 mv.addObject("product", productDao.listByProductId(productId));
	        return mv;  
	    } 

	 @RequestMapping("/productform")  
	    public ModelAndView showform(){  
	        return new ModelAndView("product_insert","command",new Product());  
	    } 
	 
	 
	  @RequestMapping(value="/saveProduct",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("product") Product product , HttpServletRequest request, 
				@RequestParam("file") MultipartFile file){  
	    	
	    	
	    	
			byte fileBytes[];
			FileOutputStream fos = null;
			
			String fileName = "";
			String pImage = "";
			ServletContext context = request.getServletContext();
			String realContextPath = context.getRealPath("/");
			String pn = product.getProductName();
			if (file != null){
				fileName = realContextPath + "/resources/img/" + pn + ".jpg";
				pImage = "resources/img/" + pn + ".jpg";
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
			
			product.setProductImage(pImage);
			
	    	productDao.addProduct(product);
	        return new ModelAndView("redirect:/viewproducts");  
	    }
	 
	 
	  @RequestMapping("/viewproducts")  
	    public ModelAndView viewusers(){  
	        List<Product> list=productDao.list();
	        return new ModelAndView("viewproducts","plist",list);  
	    }  
	  @RequestMapping(value="/editproduct/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
	        Product p=productDao.listByProductId(id);  
	        ModelAndView mv=new ModelAndView("productseditform","command",p);  
	        
	        mv.addObject("categoryList",categoryDao.list());
            String photo=p.getProductImage();
            mv.addObject("photo",photo);
	        return mv;  
	    }  
	  
	  
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("product") Product product ){  
	int cid=product.getProductCategory().getCategoryId();
	Category cc=categoryDao.get(cid);

	product.setProductCategory(cc);

	    	productDao.updateProduct(product);
	        return new ModelAndView("redirect:/viewproducts");  
	    }
}
