package com.beena.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beena.dao.CategoryDao;
import com.beena.dao.ProductDao;
import com.beena.model.Product;

@Controller
@RequestMapping("/admin")
public class AdminProductController
{

@Autowired
	CategoryDao categoryDAO;

	@Autowired
	ProductDao productDAO;

	@Autowired
	HttpServletRequest request;

	@RequestMapping("/adminprod")
	public ModelAndView AdminProd() {
		ModelAndView mv = new ModelAndView("AdminProduct");

		return mv;
	}

	/// ajax calling url

	@RequestMapping("/adminproducts/all")
	public @ResponseBody List<Product> productsall() {

		return productDAO.allProducts();

	}
	
	
	// page to add new product

		@RequestMapping("/newproduct")
		public String newProduct(ModelMap model) {
			System.out.println("Entered new category");
			//model.addAttribute("admin", true);
			model.addAttribute("newproduct", true);
			model.addAttribute("product", new Product());
			model.addAttribute("categorieslist", categoryDAO.allCategories());
			return "DispProductpage";
		}

		// adding of new product

		@RequestMapping("/addproduct")
		public String addProduct(Product product,ModelMap model) 
		{
			System.out.println(product);
			
			@SuppressWarnings("deprecation")
			File file=new File(request.getRealPath("webapp//resources//images"));
			/*System.out.println(file.exists());*/
			if(!file.exists()){
				file.mkdirs();
			}
			@SuppressWarnings("deprecation")
			File storagepath=new File(request.getRealPath("webapp//resources//images")+File.separator+product.getProductName()+".jpg");
			try{
			byte[] imagebytes=product.getImage().getBytes();
			System.out.println(imagebytes);
			BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(storagepath));
			bufferedOutputStream.write(imagebytes); 
			bufferedOutputStream.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			System.out.println(storagepath);
			productDAO.addProduct(product);
			model.addAttribute("admin", true);
			model.addAttribute("adminproducts", true);
			
			return "AdminProduct";
		}


		// page to edit product



		@RequestMapping("/{id}/editproduct")
		public String eidtproduct(@PathVariable Integer id,ModelMap model) {
			//model.addAttribute("admin", true);
			model.addAttribute("editproduct", true);
			model.addAttribute("product", productDAO.get(id));
			return "dispproduct";
		}


		// update product

		@RequestMapping("/{id}/updateproduct")
		public String updateProduct(@Valid @ModelAttribute("product")Product product,BindingResult result,ModelMap model) {
			System.out.println(product.getProductName());
			
			try{
			productDAO.update(product);
			}catch(Exception e)
			{
				System.out.println("exception in controller:::::::::::::::"+e);
			}
			//model.addAttribute("admin", true);
			model.addAttribute("adminproduct", true);
			
			return "AdminProduct";
		}


		// to delete product


		@RequestMapping("/{id}/deleteproduct")
		public String deleteProduct(@PathVariable Integer id,ModelMap model) {
		
			productDAO.delete(id);
			//model.addAttribute("admin", true);
			model.addAttribute("adminproducts", true);
			
			return "AdminProduct";
		}
	

}