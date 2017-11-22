package com.fortech.training.QuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fortech.training.QuizApp.service.QuizService;

@Controller
@RequestMapping(value="/quizzes")
public class QuizzesController {

	@Autowired private QuizService quizServ;

	@RequestMapping(method=RequestMethod.GET)
	String showQuizzes(ModelMap model) {
		model.put("quizzes", quizServ.getAll());
		return "quizzes";
	}
}
