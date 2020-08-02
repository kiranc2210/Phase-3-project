package com.MyFirstSpringBootProj.sportyshoes.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.MyFirstSpringBootProj.sportyshoes.models.CartItem;
import com.MyFirstSpringBootProj.sportyshoes.models.Product;
import com.MyFirstSpringBootProj.sportyshoes.models.Purchase;
import com.MyFirstSpringBootProj.sportyshoes.models.PurchaseItem;
import com.MyFirstSpringBootProj.sportyshoes.services.ProductService;
import com.MyFirstSpringBootProj.sportyshoes.services.PurchaseItemService;
import com.MyFirstSpringBootProj.sportyshoes.services.PurchaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Cart Controller of Sporty Shoes Application")
@Controller
public class CartController {

	@Autowired
	private ProductService productService; 

	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private PurchaseItemService purchaseItemService; 

	@ApiOperation(value = "User/Admin Will redirect to Cast Page")
	  @SuppressWarnings("unchecked")
	@GetMapping("/cart")
	    public String cart(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before adding items to cart");
		  } else {
			  // if cart is already in session then retrieve it else create a new cart list and 
			  // save it to session
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  
			  // get total of all cart items
			  BigDecimal totalValue = getCartValue(cartItems);
			  map.addAttribute("cartValue", totalValue);
			  map.addAttribute("cartItems", cartItems);
 		  }
		  
		  map.addAttribute("pageTitle", "SPORTY SHOES - YOUR CART");
	        return "cart"; 
	    }
	@ApiOperation(value = "Add product to cart")
	  @SuppressWarnings("unchecked")
	@GetMapping("/cartadditem")
	    public String cartAddItem(ModelMap map, javax.servlet.http.HttpServletRequest request,
	    		@RequestParam(value="id", required=true) String productId) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before adding items to cart");
		  } else {
			  
			  long idValue = Long.parseLong(productId);
			  // if cart is already in session then retrieve it else create a new cart list and 
			  // save it to session
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  if (isItemInCart(cartItems, idValue)) {
				  map.addAttribute("error", "This item is already in your cart");
			  } else {
				  Product product = productService.getProductById(idValue);
				  CartItem item = new CartItem();
				  item.setProductId(idValue);
				  item.setQty(1);
				  item.setRate(product.getPrice());
				  BigDecimal dprice = item.getRate().multiply(new BigDecimal(item.getQty())); 
				  item.setPrice(dprice); 
				  item.setName(product.getName()); 
				  cartItems.add(item);
				  
				  session.setAttribute("cart_items", cartItems);
			  }
		  }
		  
	        return "redirect:cart"; 
	    }	  
	  
	@ApiOperation(value = "Delete the product from the cart by ID")
	  @DeleteMapping("/cartdeleteitem")
	    public String cartDeleteItem(ModelMap map, javax.servlet.http.HttpServletRequest request, 
	    		@RequestParam(value="id", required=true) String id) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before deleting items from cart");
		  } else {
			  long idValue = Long.parseLong(id);
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  	  
			  for(CartItem item: cartItems) {
				  if (item.getProductId() == idValue) {
					  cartItems.remove(item);
					  session.setAttribute("cart_items", cartItems);
					  break;
				  }
			   }
		  }	
	        return "redirect:cart"; 
	    }	

	@ApiOperation(value = "Procduct Checkout")
	  @SuppressWarnings("unchecked")
	@GetMapping("/checkout")
	    public String checkout(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before checking out");
		  } else {
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  BigDecimal totalValue = getCartValue(cartItems);
			  map.addAttribute("cartValue", totalValue);
			  map.addAttribute("cartItems", cartItems);
		  }
		  map.addAttribute("pageTitle", "SPORTY SHOES - CHECKOUT");
	        return "checkout"; 
	    }

	@ApiOperation(value = "Complete Purchase")
	  @SuppressWarnings("unchecked")
	@GetMapping("/completepurchase")
	    public String completePurchase(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before completing purchase");
		  } else {
			  // take items from cart and update the databae 
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  BigDecimal totalValue = getCartValue(cartItems);
			  
			  long userId = (Long) session.getAttribute("user_id") ;
			  
			  Purchase purchase = new Purchase();
			  purchase.setUserId(userId);
			  purchase.setDate(Calendar.getInstance().getTime());
			  purchase.setTotal(totalValue);
			  long purchaseId = purchaseService.updatePurchase(purchase).getID();
			  
			  for(CartItem item: cartItems) {
				  PurchaseItem pItem = new PurchaseItem();
				  pItem.setPurchaseId(purchaseId);
				  pItem.setProductId(item.getProductId());
				  pItem.setUserId(userId);
				  pItem.setRate(item.getRate());
				  pItem.setQty(item.getQty());
				  pItem.setPrice(item.getPrice());
				  
				  purchaseItemService.updateItem(pItem);
			  }
			  map.addAttribute("cartValue", totalValue);
			  map.addAttribute("cartItems", cartItems);

		  }
		  
	        return "redirect:confirm";  
	    }

	
	@ApiOperation(value = "Payment Gatway")
	  @SuppressWarnings("unchecked")
	@GetMapping("/gateway")
	    public String gateway(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before making payment");
		  } else {
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  BigDecimal totalValue = getCartValue(cartItems);
			  map.addAttribute("cartValue", totalValue);
			  map.addAttribute("cartItems", cartItems);

		  }
		  
		  map.addAttribute("pageTitle", "SPORTY SHOES - PAYMENT GATEWAY");
	        return "gateway"; 
	    }
	  
	
	@ApiOperation(value = "Payment Confirmation")
	  @SuppressWarnings("unchecked")
	@GetMapping("/confirm")
	    public String confirm(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  // check if user is logged in
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  map.addAttribute("error", "Error, You need to login before completing the purchase");
		  } else {
			  // clear items from cart as order has completed 
			  List<CartItem> cartItems = new ArrayList<CartItem>();
			  if (session.getAttribute("cart_items") != null)
				  cartItems = (List<CartItem>) session.getAttribute("cart_items");
			  BigDecimal totalValue = getCartValue(cartItems);
			  map.addAttribute("cartValue", totalValue);

			  
			  cartItems.clear();
			  session.setAttribute("cart_items", null);
		  }
		  map.addAttribute("pageTitle", "SPORTY SHOES - PURCHASE CONFIRMATION");
	        return "confirm"; 
	    }	  
	  
	  /**
	   * Check if an item is already in the cart
	   * @param list
	   * @param item
	   * @return
	   */
	  private boolean isItemInCart(List<CartItem> list, long item) {
		  boolean retVal = false;
		  
		  for(CartItem thisItem: list) {
			  if (item == thisItem.getProductId()) {
				  retVal = true;
				  break;
			  }
		  }
		  return retVal;
	  } 

	  /**
	   * Get total value of items in cart
	   * @param list
	   * @return
	   */
	  private BigDecimal getCartValue(List<CartItem> list) {
		  BigDecimal total = new BigDecimal(0.0);
		  
		  for(CartItem item: list) {
			  BigDecimal dprice = item.getRate().multiply(new BigDecimal(item.getQty()));
			  total= total.add(dprice);
		   }
		  return total;
	  }

}
