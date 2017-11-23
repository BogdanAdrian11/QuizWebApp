package com.fortech.training.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fortech.training.QuizApp.entity.Quiz;
import com.fortech.training.QuizApp.service.QuizService;

@Controller
@RequestMapping(value="/questions")
public class QuestionsController {

	@Autowired QuizService quizServ;

	@RequestMapping(value="/{quizId}", method=RequestMethod.GET)
	public ModelAndView showQuestions(ModelAndView modelAndView,
							@PathVariable("quizId") int quizId) {		
		modelAndView.setViewName("questions");
		
		Quiz quiz = quizServ.get(quizId);
		modelAndView.getModel().put("quiz", quiz);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{quizId}", method=RequestMethod.POST)
	public String showResult(ModelMap model, @RequestParam(required=false) List<Integer> result, 
					@PathVariable("quizId") int quizId) {
	
		double score = quizServ.getResult(quizId, result);
		model.put("score", score);
		return "yourScore";
	}
}
