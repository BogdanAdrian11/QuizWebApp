package com.fortech.training.QuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortech.training.QuizApp.service.UserService;

@Controller
public class LoginController {
	@Autowired private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String name,
			@RequestParam String password) {
		if (userService.validateUser(name, password)) {
			model.put("name", name);
			return "admin";
		} else {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
	}
}
