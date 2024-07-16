package com.krishna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krishna.entities.UserAccount;
import com.krishna.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("user", new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute("user") UserAccount user, Model model) {
		try {
			service.saveOrUpdateUser(user);
			model.addAttribute("success","User saved sucessfully...");
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error","somthing went wrong...");
		}
		return "index";
	}
	
	@GetMapping("/users")
	public String getAllUsers(Model model) {
		List<UserAccount> accounts = service.getAllAccounts();
		model.addAttribute("users", accounts);
		return "view";
	}
	
	@GetMapping("/edit")
	public String updateUser(@RequestParam("userId") Integer userId, Model model) {
		UserAccount user = service.getuser(userId);
		model.addAttribute("user", user);
		return "update";
	}
	@GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Integer userId, Model model) {
    	boolean deleteUser = service.deleteUser(userId);
    	if(deleteUser) {
    		model.addAttribute("msg", "user deleted successfully...");
    	}else {
    		model.addAttribute("msg", "something went wrong...");
    	}
    	return "redirect:/users";
    }
	
	@GetMapping("/update")
	public String statusUpdate(@RequestParam("userId") Integer userId,@RequestParam("status") String status) {
		
		service.updateAccStatus(userId, status);
		
		return "redirect:/users";
	}
}
