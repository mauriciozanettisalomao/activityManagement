package br.com.activitymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome(Model model){
		
		return "home";	
	}
	
	@RequestMapping("/activitytypegroup")
	public String showActivityTypeGroup(Model model){
		
		return "activityTypeGroup";	
	}	
	
}
