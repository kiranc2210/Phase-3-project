package com.MyFirstSpringBootProj.sportyshoes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
    public String dashboard(ModelMap map) 
    {
	  map.addAttribute("pageTitle", "SPORTY SHOES - DASHBOARD");
        return "dashboard"; 
    }

}
