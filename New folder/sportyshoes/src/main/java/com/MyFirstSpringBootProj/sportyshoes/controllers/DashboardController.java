package com.MyFirstSpringBootProj.sportyshoes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Dash board Controller For Sporty SHoes Application")
@Controller
public class DashboardController {
	
	
	@ApiOperation(value = "On succussfull Login user will redirect to \"Dashboard\"  or will redirect to Login page")
	@GetMapping("/dashboard")
    public String dashboard(ModelMap map) 
    {
	  map.addAttribute("pageTitle", "SPORTY SHOES - DASHBOARD");
        return "dashboard"; 
    }

}
