package com.fortech.training.QuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fortech.training.QuizApp.entity.Quiz;
import com.fortech.training.QuizApp.service.QuizService;

@Controller
@RequestMapping(value="/questions")
public class QuestionsController {

	@Autowired QuizService quizServ;

	@RequestMapping(value="/{quizId}", method=RequestMethod.GET)
	public String showQuestions(ModelMap model, @PathVariable("quizId") int quizId) {
		Quiz quiz = quizServ.get(quizId);
		model.put("quiz", quiz);
		return "questions";
	}
	
	@RequestMapping(value="/{quizId}", method=RequestMethod.POST)
	public String showResult() {	
		return "welcome";
	}

	
}
