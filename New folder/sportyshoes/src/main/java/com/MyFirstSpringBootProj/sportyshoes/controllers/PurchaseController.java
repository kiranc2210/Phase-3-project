package com.MyFirstSpringBootProj.sportyshoes.controllers;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;


import com.MyFirstSpringBootProj.sportyshoes.models.Product;
import com.MyFirstSpringBootProj.sportyshoes.models.Purchase;
import com.MyFirstSpringBootProj.sportyshoes.models.PurchaseItem;
import com.MyFirstSpringBootProj.sportyshoes.services.ProductService;
import com.MyFirstSpringBootProj.sportyshoes.services.PurchaseItemService;
import com.MyFirstSpringBootProj.sportyshoes.services.PurchaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 

@Api(value="Purshase Controller For Sporty Shoes Application")
@Controller
public class PurchaseController {

	@Autowired
	private ProductService productService; 
	
	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private PurchaseItemService purchaseItemService;

	
	@ApiOperation(value = "User will be redirected to Purchase Page if he/she already log in to Application or else  will redirect to member login page")
	  @GetMapping(value = "/memberpurchases")
	    public String memberpurchases(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  return "login";
		  }
		  long userId = (Long) session.getAttribute("user_id");
		  
		  List<Purchase> list = purchaseService.getAllItemsByUserId(userId);
		  
		  BigDecimal total = new BigDecimal(0.0);
		  // map purchase items to each purchase for display
		  HashMap<Long, String> mapItems = new HashMap<Long, String>();
		  
		  for(Purchase purchase: list) {
			  total = total.add(purchase.getTotal());
			  
			  List<PurchaseItem> itemList = purchaseItemService.getAllItemsByPurchaseId(purchase.getID());
			  StringBuilder sb = new StringBuilder("");
			  for(PurchaseItem item: itemList) {
				  Product product = productService.getProductById(item.getProductId());
				  if (product != null) {
					  sb.append(product.getName() + ", " + 
						  	item.getQty() + " units @" + item.getRate() + " = " 
						  	+ item.getPrice() + "<br>");
				  }
			  }
			  mapItems.put(purchase.getID(), sb.toString());
		  }
		  map.addAttribute("totalAmount", total);
		  map.addAttribute("list", list);
		  map.addAttribute("mapItems", mapItems);
		  map.addAttribute("pageTitle", "SPORTY SHOES - YOUR ORDERS");
		  
	       return "purchases"; 
	    }		  
}
