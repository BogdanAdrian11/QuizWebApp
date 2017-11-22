package com.fortech.training.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fortech.training.QuizApp.entity.Quiz;
import com.fortech.training.QuizApp.service.QuizService;

@Controller
@RequestMapping(value = {"/", "/index"})
public class MainController {

	@Autowired private QuizService quizServ;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showIndex(ModelMap model) {
		List<Quiz> quizzes = quizServ.getForIndex();
		model.put("quizzes", quizzes);
		return "index";
	}
}
