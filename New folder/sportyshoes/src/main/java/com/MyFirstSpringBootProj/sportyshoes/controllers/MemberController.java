package com.MyFirstSpringBootProj.sportyshoes.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyFirstSpringBootProj.sportyshoes.models.Users;
import com.MyFirstSpringBootProj.sportyshoes.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Member Controller For Sporty SHoes Application")
@Controller
public class MemberController {

	@Autowired
	private UserService userService;
//==============================================================================
	@ApiOperation(value = "Redirect To member Login Page")
	@GetMapping("/login")
	public String login(ModelMap map) {

		map.addAttribute("pageTitle", "SPORTY SHOES - MEMBER LOGIN");
		return "login";

	}
//=====================================================================================
	@ApiOperation(value = "Redirect To member Registration Page")
	@GetMapping("/signup")
	public String signup(ModelMap map) {
		map.addAttribute("pageTitle", "SPORTY SHOES - MEMBER REGISTRATION");
		return "register";
	}
//====================================================================================
	@ApiOperation(value = "User Logged out from the Application & will  redirect to Home Page")
	@GetMapping("/logout")
	public String logout(javax.servlet.http.HttpServletRequest request) {
		HttpSession session = request.getSession();
	  	session.invalidate();

		return "redirect:home";
	}
//=======================================================================================	
	@ApiOperation(value = "User Logged out from the Application & will  redirect to Home Page")
	@PostMapping("/signup")
	public String signupAction(ModelMap map, javax.servlet.http.HttpServletRequest request,
			@RequestParam(value = "email_id", required = true) String emailId,
			@RequestParam(value = "pwd", required = true) String pwd,
			@RequestParam(value = "pwd2", required = true) String pwd2,
			@RequestParam(value = "fname", required = true) String fname,
			@RequestParam(value = "lname", required = true) String lname,
			@RequestParam(value = "age", required = true) String age,
			@RequestParam(value = "address", required = true) String address) {

		if (emailId == null || emailId.equals("")) {
			map.addAttribute("error", "Email id is required.");
			return "register";
		}

		if (pwd == null || pwd2 == null || pwd.equals("") || pwd2.equals("")) {
			map.addAttribute("error", "Error , Incomplete passwords submitted.");
			return "register";
		}

		if (!pwd.equals(pwd2)) {
			map.addAttribute("error", "Error , Passwords do not match.");
			return "register";
		}

		if (fname == null || fname.equals("")) {
			map.addAttribute("error", "First name is required.");
			return "register";
		}

		if (lname == null || lname.equals("")) {
			map.addAttribute("error", "Last name is required.");
			return "register";
		}
		if (age == null || age.equals("")) {
			age = "0";
		}

		Users user = userService.getUserByEmailId(emailId);
		if (user != null) {
			map.addAttribute("error", "This email id already exists.");
			return "register";
		}
		user = new Users();
	
		user.setEmailId(emailId);
		user.setFname(fname);
		user.setLname(lname);
		user.setAge(Integer.parseInt(age));
		user.setAddress(address);
		user.setPwd(pwd);

		Users user1=userService.addUsers(user);
		map.addAttribute("addedUser", user1.getFname()+" "+user1.getLname());
		return "register-confirm";
	}
//================================================================================================
	@ApiOperation(value = "On succussfull Login user will redirect to \"Dashboard\"  or will redirect to Login page")
	@PostMapping("/login")
	public String loginAction(ModelMap map, @RequestParam(value = "email_id", required = true) String emailId,
			@RequestParam(value = "pwd", required = true) String pwd, javax.servlet.http.HttpServletRequest request) {
	
		Users user = userService.getUserByEmailId(emailId);
		
		if (user == null) {
			map.addAttribute("error", "Login failed");
			return "login";
		} else {
			if (!(user.getEmailId().equals(emailId) && user.getPwd().equals(pwd))) {
				map.addAttribute("error", "Username and Password are Incorrect");
				return "login";
			}

		}
		  HttpSession session = request.getSession();
		  session.setAttribute("user_id", user.getID());
		map.addAttribute("user", user);

		return "redirect:dashboard";
	}
	
//=======================================================================================
	@ApiOperation(value = " user will redirect to Edit page to edit his/her profile.")
	@GetMapping("/editprofile")
	public String editProfile(ModelMap map, javax.servlet.http.HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			return "login";
		}
		Users user = userService.getUserById( (long) session.getAttribute("user_id"));

		map.addAttribute("pageTitle", "SPORTY SHOES - MEMBER EDIT PROFILE");
		map.addAttribute("user", user);

		return "edit-profile";
	}
//======================================================================================
	@ApiOperation(value = "user can edit his/her profile in this edit page")
	 @PostMapping("/editprofile")
	    public String editProfileAction(ModelMap map,
	    		javax.servlet.http.HttpServletRequest request, 
	    		@RequestParam(value="user_id", required=true) String userId,
	    		 @RequestParam(value="pwd", required=true) String pwd,
	    		 @RequestParam(value="pwd2", required=true) String pwd2,
	    		 @RequestParam(value="fname", required=true) String fname,
	    		 @RequestParam(value="lname", required=true) String lname,
	    		 @RequestParam(value="age", required=true) String age,
	    		 @RequestParam(value="address", required=true) String address) 
	    {
		  
		  HttpSession session = request.getSession();
		  if (session.getAttribute("user_id") == null) {
			  return "login";
		  }
		  
		  Users user = userService.getUserById((Long) session.getAttribute("user_id"));
		  map.addAttribute("user", user);
		  
		  if (pwd == null || pwd2 == null || pwd.equals("") || pwd2.equals("")) {
			  map.addAttribute("error", "Error , Incomplete passwords submitted.");
			  return "edit-profile";
		  }
		  
		  if (!pwd.equals(pwd2)) {
			  map.addAttribute("error", "Error , Passwords do not match.");
			  return "edit-profile";
		  }
		  
		  if (fname == null || fname.equals("")) {
			  map.addAttribute("error", "First name is required.");
			  return "edit-profile";
		  }

		  if (lname == null || lname.equals("")) {
			  map.addAttribute("error", "Last name is required.");
			  return "edit-profile";
		  }
		  if (age == null || age.equals("")) {
			  age = "0";
		  }
		  user.setFname(fname);
		  user.setLname(lname);
		  user.setAge(Integer.parseInt(age));
		  user.setAddress(address);
		  user.setPwd(pwd);
		  
		  userService.updateUser(user);
		  
	        return "dashboard"; 
	    }

}
