package com.fortech.training.QuizApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContact() {
		return "contact";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String handleContactForm(ModelMap model, @RequestParam String your_name,
									@RequestParam String your_email,
									@RequestParam String your_enquiry) {
		model.put("name", your_name);
		return "welcome";
	}
}
