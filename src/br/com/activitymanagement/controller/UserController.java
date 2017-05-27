package br.com.activitymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.activitymanagement.model.entity.User;
import br.com.activitymanagement.service.UserService;

@Controller
public class UserController {

	private UserService usuarioService;
	
	@Autowired
	public void setUsuarioService(UserService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping("/allusers")
	public String showAllUsers(Model model){
		
		List<User> users = usuarioService.getAllUsers();
		
		for(User u : users){
			System.out.println(u);
		}
		
		model.addAttribute("users", users);
		
		return "users";	
	}
	
	@RequestMapping("/createuser")
	public String showFormCreateUser(Model model, User user){
		
		return "createuser";	
	}
	
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public String showUserSaved(Model model, User user){
		System.out.println(user);
		usuarioService.saveOrUpdate(user);

		List<User> u = java.util.Arrays.asList(user);
		
		model.addAttribute("users", u);
		return "users";	
	}

	
}
