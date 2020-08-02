package com.MyFirstSpringBootProj.sportyshoes.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import com.MyFirstSpringBootProj.sportyshoes.models.Category;
import com.MyFirstSpringBootProj.sportyshoes.models.Product;
import com.MyFirstSpringBootProj.sportyshoes.services.CategoryService;
import com.MyFirstSpringBootProj.sportyshoes.services.ProductService;

import io.swagger.annotations.ApiOperation;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService; 

	@Autowired
	private ProductService productService; 
	
	@ApiOperation(value = "On The Application Load User will be landed on to Index or Home Page")
	  @GetMapping({"/", "/home"})
	    public String home(ModelMap map,  javax.servlet.http.HttpServletRequest request) 
	    {
		    HttpSession session = request.getSession();
			List<Product> list = productService.getAllProducts();
			
			// use MAP to map the category names to product rows
			 HashMap<Long, String> mapCats = new HashMap<Long, String>();
			  for(Product product: list) {
				  Category category = categoryService.getCategoryById(product.getCategoryId());
				  if (category != null)
					  mapCats.put(product.getID(), category.getName());
			  }
			 // session.setAttribute(name, value);
			map.addAttribute("list", list);
			map.addAttribute("mapCats", mapCats);
		    map.addAttribute("pageTitle", "SPORTY SHOES - HOMEPAGE"); 
	        return "index"; 
	    }	

}
